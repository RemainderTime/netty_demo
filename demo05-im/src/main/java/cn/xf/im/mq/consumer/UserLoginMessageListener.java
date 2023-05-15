package cn.xf.im.mq.consumer;

import cn.xf.im.constants.ImConstant;
import cn.xf.im.domain.MessagePack;
import cn.xf.im.dto.UserHolderDto;
import cn.xf.im.enums.ClientType;
import cn.xf.im.enums.DeviceMultiLoginEnum;
import cn.xf.im.holder.UserChannelHolder;
import cn.xf.im.utils.RedissonUtil;
import com.alibaba.fastjson.JSON;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;

import java.util.List;

/**
 * @Description: 多端登陆处理器
 * @ClassName: UserLoginMessageListener
 * @Author: xiongfeng
 * @Date: 2023/5/15 10:10
 * @Version: 1.0
 */
public class UserLoginMessageListener {

	private Integer loginModel;

	public UserLoginMessageListener(Integer loginModel) {
		this.loginModel = loginModel;
	}

	public void listenerUserLogin() {

		RTopic topic = RedissonUtil.getRedissonClient().getTopic(ImConstant.RedisConstant.UserLoginChannel);
		topic.addListener(String.class, new MessageListener<String>() {
			@Override
			public void onMessage(CharSequence charSequence, String s) {

				UserHolderDto dto = JSON.parseObject(s, UserHolderDto.class);
				//获取当前用户客户端建立的连接对象集合
				List<NioSocketChannel> nioSocketChannelList = UserChannelHolder.getNioSocketChannelList(dto.getAppId(), dto.getUserId());

				for (NioSocketChannel channel : nioSocketChannelList) {
					Integer clientType = (Integer) channel.attr(AttributeKey.valueOf(ImConstant.ClientType)).get();
					String imei = (String) channel.attr(AttributeKey.valueOf(ImConstant.Imei)).get();
					if (loginModel == DeviceMultiLoginEnum.ONE.getLoginMode()) {
						if (!(clientType + ":" + imei).equals(dto.getClientType() + ":" + dto.getImei())) {
							MessagePack<Object> messagePack = new MessagePack<>();
							String userId = (String) channel.attr(AttributeKey.valueOf(ImConstant.UserId)).get();
							messagePack.setToId(userId);
							messagePack.setUserId(userId);
							messagePack.setCommand(ImConstant.CommandConstant.MUTUALLOGIN);
							channel.writeAndFlush(messagePack);
						}
					} else if (loginModel == DeviceMultiLoginEnum.TWO.getLoginMode()) {
						if (dto.getClientType() == ClientType.WEB.getCode()) {
							continue;
						}
						if (clientType == ClientType.WEB.getCode()) {
							continue;
						}
						if (!(clientType + ":" + imei).equals(dto.getClientType() + ":" + dto.getImei())) {
							MessagePack<Object> messagePack = new MessagePack<>();
							String userId = (String) channel.attr(AttributeKey.valueOf(ImConstant.UserId)).get();
							messagePack.setToId(userId);
							messagePack.setUserId(userId);
							messagePack.setCommand(ImConstant.CommandConstant.MUTUALLOGIN);
							channel.writeAndFlush(messagePack);
						}
					} else if (loginModel == DeviceMultiLoginEnum.THREE.getLoginMode()) {

						if (dto.getClientType() == ClientType.WEB.getCode()) {
							continue;
						}

						Boolean isSameClient = false;
						if ((clientType == ClientType.IOS.getCode() ||
								clientType == ClientType.ANDROID.getCode()) &&
								(dto.getClientType() == ClientType.IOS.getCode() ||
										dto.getClientType() == ClientType.ANDROID.getCode())) {
							isSameClient = true;
						}

						if ((clientType == ClientType.MAC.getCode() ||
								clientType == ClientType.WINDOWS.getCode()) &&
								(dto.getClientType() == ClientType.MAC.getCode() ||
										dto.getClientType() == ClientType.WINDOWS.getCode())) {
							isSameClient = true;
						}

						if (isSameClient && !(clientType + ":" + imei).equals(dto.getClientType() + ":" + dto.getImei())) {
							MessagePack<Object> messagePack = new MessagePack<>();
							String userId = (String) channel.attr(AttributeKey.valueOf(ImConstant.UserId)).get();
							messagePack.setToId(userId);
							messagePack.setUserId(userId);
							messagePack.setCommand(ImConstant.CommandConstant.MUTUALLOGIN);
							channel.writeAndFlush(messagePack);
						}

					}
				}

			}
		});

	}
}
