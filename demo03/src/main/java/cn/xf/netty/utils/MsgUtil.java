package cn.xf.netty.utils;

import cn.xf.netty.domain.MsgInfo;

/**
 * @Description:
 * @ClassName: MsgUtil
 * @Author: xiongfeng
 * @Date: 2023/5/6 11:11
 * @Version: 1.0
 */
public class MsgUtil {

	public static MsgInfo buildMsg(String channelId, String msgContent) {
		return new MsgInfo(channelId,msgContent);
	}
}
