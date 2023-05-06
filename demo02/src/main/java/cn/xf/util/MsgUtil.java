package cn.xf.util;

import cn.xf.domain.MsgBody;

/**
 * @Description:
 * @ClassName: MsgUtil
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:39
 * @Version: 1.0
 */
public class MsgUtil {

	/**
	 * 构建protobuf消息体
	 */
	public static MsgBody buildMsg(String channelId, String msgInfo) {
		MsgBody.Builder msg = MsgBody.newBuilder();
		msg.setChannelId(channelId);
		msg.setMsgInfo(msgInfo);
		return msg.build();
	}
}
