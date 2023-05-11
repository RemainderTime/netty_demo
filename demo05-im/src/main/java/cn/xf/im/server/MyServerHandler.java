package cn.xf.im.server;

import cn.xf.im.constants.ImConstant;
import cn.xf.im.domain.LoginPack;
import cn.xf.im.domain.Message;
import cn.xf.im.domain.UserSession;
import cn.xf.im.holder.UserChannelHolder;
import cn.xf.im.utils.RedissonUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

/**
 * @Description:
 * @ClassName: MyServerHanlder
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:56
 * @Version: 1.0
 */
public class MyServerHandler extends SimpleChannelInboundHandler<Message> {
	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, Message msg) throws Exception {

		Channel channel = channelHandlerContext.channel();
		Integer command = msg.getMessageHeader().getCommand();
		if (command  == ImConstant.CommandConstant.LOGIN) {
			//用户登陆
			LoginPack loginPack = JSON.parseObject(JSONObject.toJSONString(msg.getMessagePack()), new TypeReference<LoginPack>() {
			}.getType());

			//为channel设置userId
			channel.attr(AttributeKey.valueOf(ImConstant.UserId)).set(loginPack.getUserId());
			channel.attr(AttributeKey.valueOf(ImConstant.AppId)).set(msg.getMessageHeader().getAppId());
			channel.attr(AttributeKey.valueOf(ImConstant.ClientType)).set(msg.getMessageHeader().getClientType());
			channel.attr(AttributeKey.valueOf(ImConstant.Imei)).set(msg.getMessageHeader().getImei());

			UserSession userSession = new UserSession();
			userSession.setUserId(loginPack.getUserId());
			userSession.setImei(msg.getMessageHeader().getImei());
			userSession.setClientType(msg.getMessageHeader().getClientType());
			userSession.setAppId(msg.getMessageHeader().getAppId());
			userSession.setConnectStatus(ImConstant.UserStatusConstant.ONLINE);

			//存储登陆用户数据到redis中
			RedissonClient redissonClient = RedissonUtil.getRedissonClient();
			RMap<Object, Object> map = redissonClient.getMap(msg.getMessageHeader().getAppId() + ImConstant.SessionConstant.USER_SESSION + loginPack.getUserId());
			map.put(msg.getMessageHeader().getClientType() + ":" + msg.getMessageHeader().getImei(), JSONObject.toJSONString(userSession));

			UserChannelHolder.channelPut(loginPack.getUserId(), msg.getMessageHeader().getAppId(), msg.getMessageHeader().getClientType(), (NioSocketChannel) channel);
			//用户退出
		}else if(command == ImConstant.CommandConstant.LOGOUT){
			Integer userId = (Integer) channel.attr(AttributeKey.valueOf(ImConstant.UserId)).get();
			Integer appId = (Integer) channel.attr(AttributeKey.valueOf(ImConstant.AppId)).get();
			Integer clientType = (Integer) channel.attr(AttributeKey.valueOf(ImConstant.ClientType)).get();
			String imei = (String) channel.attr(AttributeKey.valueOf(ImConstant.Imei)).get();

			RedissonClient redissonClient = RedissonUtil.getRedissonClient();
			RMap<Object, Object> map = redissonClient.getMap(appId + ImConstant.SessionConstant.USER_SESSION + userId);
			map.remove(clientType + ":" + imei);

			UserChannelHolder.remove((NioSocketChannel) channel);
			channel.close();
		}else if(command == ImConstant.CommandConstant.PING){
			channel.attr(AttributeKey.valueOf(ImConstant.ReadTime)).set(System.currentTimeMillis());
		}


	}
}
