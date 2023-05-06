package cn.xf.netty.util;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Description:
 * @ClassName: ChannelHandler
 * @Author: xiongfeng
 * @Date: 2023/5/6 13:40
 * @Version: 1.0
 */
public class ChannelHandler {

	//用于存放用户Channel信息，也可以建立map结构模拟不同的消息群
	public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
