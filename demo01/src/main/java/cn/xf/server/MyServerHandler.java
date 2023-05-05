package cn.xf.server;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.slf4j.Slf4j;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @ClassName: MyServerHandler
 * @Author: xiongfeng
 * @Date: 2023/5/5 15:31
 * @Version: 1.0
 */

@Slf4j
public class MyServerHandler extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(MyServerHandler.class);


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		SocketChannel channel = (SocketChannel) ctx.channel();

		logger.error("链接报告开始");
		logger.error("链接报告信息：有一客户端链接到本服务端");
		logger.error("链接报告IP:{}", channel.localAddress().getHostString());
		logger.error("链接报告Port:{}", channel.localAddress().getPort());
		logger.error("链接报告完毕");
		//通知客户端链接建立成功
		String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";
		ctx.writeAndFlush(str);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.error("客户端断开链接{}", ctx.channel().localAddress().toString());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//接收msg消息{与上一章节相比，此处已经不需要自己进行解码}
		logger.error(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 服务端接收到消息：" + msg);
		//通知客户端链消息发送成功
		String str = "服务端收到：" + new Date() + " " + msg + "\r\n";
		ctx.writeAndFlush(str);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		logger.error("异常信息：\r\n" + cause.getMessage());
	}
}
