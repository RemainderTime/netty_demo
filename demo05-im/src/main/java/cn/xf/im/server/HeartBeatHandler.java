package cn.xf.im.server;

import cn.xf.im.constants.ImConstant;
import cn.xf.im.domain.LoginPack;
import cn.xf.im.domain.UserSession;
import cn.xf.im.holder.UserChannelHolder;
import cn.xf.im.utils.RedissonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.util.StringUtils;

/**
 * @Description: 心跳检测
 * @ClassName: MyIdleStateHandler
 * @Author: xiongfeng
 * @Date: 2023/5/11 14:22
 * @Version: 1.0
 */
@Slf4j
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

	private Long longTime;

	public HeartBeatHandler(Long longTime) {
		this.longTime = longTime;
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.READER_IDLE) {
				log.error("进入读空闲区");
			} else if (event.state() == IdleState.WRITER_IDLE) {
				log.error("进入写空闲区");
			} else if (event.state() == IdleState.ALL_IDLE) {
				log.error("进入读写空闲区----");
				Long readTime = (Long) ctx.channel().attr(AttributeKey.valueOf(ImConstant.ReadTime)).get();
				long currentTimeMillis = System.currentTimeMillis();
				//读写时间超时，用户设置为离线状态
				if (readTime != null && currentTimeMillis - readTime > longTime) {
					Integer userId = (Integer) ctx.channel().attr(AttributeKey.valueOf(ImConstant.UserId)).get();
					Integer appId = (Integer) ctx.channel().attr(AttributeKey.valueOf(ImConstant.AppId)).get();
					Integer clientType = (Integer) ctx.channel().attr(AttributeKey.valueOf(ImConstant.ClientType)).get();
					String imei = (String) ctx.channel().attr(AttributeKey.valueOf(ImConstant.Imei)).get();

					UserChannelHolder.remove((NioSocketChannel) ctx.channel());

					RedissonClient redissonClient = RedissonUtil.getRedissonClient();
					RMap<Object, Object> map = redissonClient.getMap(appId + ImConstant.SessionConstant.USER_SESSION + userId);
					String userStr = (String) map.get(clientType + ":" + imei);

					if (!StringUtil.isBlank(userStr)) {
						UserSession userSession = JSON.parseObject(userStr, UserSession.class);
						userSession.setConnectStatus(ImConstant.UserStatusConstant.OFFLINE);
						map.put(clientType + ":" + imei, JSONObject.toJSONString(userSession));
					}
					ctx.channel().close();
				}
			}

		}

	}
}
