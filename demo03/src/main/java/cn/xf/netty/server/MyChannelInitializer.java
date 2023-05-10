package cn.xf.netty.server;

import cn.xf.netty.codec.ObjDecoder;
import cn.xf.netty.codec.ObjEncoder;
import cn.xf.netty.domain.MsgInfo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.nio.charset.Charset;

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
//		p.addLast(new ObjDecoder(MsgInfo.class));
//		p.addLast(new ObjEncoder(MsgInfo.class));
		//添加链接超时时间
		p.addLast(new IdleStateHandler(2, 2, 5));
		p.addLast(new StringEncoder(Charset.forName("GBK")));
		p.addLast(new StringDecoder(Charset.forName("GBK")));

		p.addLast(new MyServerHandler());
	}
}
