package cn.xf.netty.server;

import cn.xf.netty.codec.ObjDecoder;
import cn.xf.netty.codec.ObjEncoder;
import cn.xf.netty.domain.MsgInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @Description:
 * @ClassName: MyChannelInitializer
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:11
 * @Version: 1.0
 */
public class MyChannelInitializer extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel socketChannel) throws Exception {

		ChannelPipeline p = socketChannel.pipeline();
		//对象传输处理
		p.addLast(new ObjDecoder(MsgInfo.class));
		p.addLast(new ObjEncoder(MsgInfo.class));

		p.addLast(new MyServerHandler());
	}
}
