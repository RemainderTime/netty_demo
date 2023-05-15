package cn.xf.im.holder;

import cn.xf.im.dto.UserHolderDto;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.hibernate.validator.constraints.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @ClassName: UserChannelHodler
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:41
 * @Version: 1.0
 */
public class UserChannelHolder {

	private static Map<UserHolderDto, NioSocketChannel> USER_CHANNEL_MAP = new ConcurrentHashMap<>();

	public static void channelPut(Integer userId, Integer appId, Integer clientType,String imei, NioSocketChannel channel) {
		UserHolderDto dto = new UserHolderDto();
		dto.setUserId(userId);
		dto.setAppId(appId);
		dto.setClientType(clientType);
		dto.setImei(imei);
		USER_CHANNEL_MAP.put(dto, channel);
	}

	public static void remove(NioSocketChannel channel) {
		USER_CHANNEL_MAP.keySet().stream().filter(e -> USER_CHANNEL_MAP.get(e) == channel).forEach(x -> {
			USER_CHANNEL_MAP.remove(x);
		});
	}


	public static List<NioSocketChannel> getNioSocketChannelList(Integer appId, Integer userId){
		Set<UserHolderDto> dtos = USER_CHANNEL_MAP.keySet();
		List<NioSocketChannel> channels =new ArrayList<>();
		dtos.forEach(x->{
			if(x.getAppId().equals(appId) && x.getUserId().equals(userId)){
				channels.add(USER_CHANNEL_MAP.get(x));
			}
		});
		return channels;
	}


}
