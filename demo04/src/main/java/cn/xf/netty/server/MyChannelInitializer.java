package cn.xf.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

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
		p.addLast("http-codec", new HttpServerCodec());
		p.addLast("aggregator", new HttpObjectAggregator(65536));
		p.addLast("http-chunked", new ChunkedWriteHandler());

		p.addLast(new MyServerHandler());
	}
}

