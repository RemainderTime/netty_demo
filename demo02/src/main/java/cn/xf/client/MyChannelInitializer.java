package cn.xf.client;

import cn.xf.domain.MsgBody;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

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
		p.addLast(new ProtobufVarint32FrameDecoder());
		p.addLast(new ProtobufDecoder(MsgBody.getDefaultInstance()));
		p.addLast(new ProtobufVarint32LengthFieldPrepender());
		p.addLast(new ProtobufEncoder());

		p.addLast(new MyClientHandler());
	}
}
