package cn.xf.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @ClassName: ApiTest
 * @Author: xiongfeng
 * @Date: 2023/5/5 16:47
 * @Version: 1.0
 */
public class ApiTest {

	public static void main(String[] args) {

		EventLoopGroup workGroup = new NioEventLoopGroup();

		try {
			Bootstrap b = new Bootstrap();
			b.group(workGroup)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.AUTO_READ, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline pipeline = socketChannel.pipeline();
							// 基于换行符号
							pipeline.addLast(new LineBasedFrameDecoder(1024));
							pipeline.addLast(new StringDecoder(Charset.forName("GBK")));
							pipeline.addLast(new StringEncoder(Charset.forName("GBK")));
							pipeline.addLast(new SimpleChannelInboundHandler() {
								@Override
								protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {

									System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 客户端接收到消息：" + msg);
								}
							});
						}
					});

			ChannelFuture f = b.connect("127.0.0.1", 7397).sync();

			f.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
			f.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
			f.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
			f.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");
			f.channel().writeAndFlush("你好，SpringBoot启动的netty服务端，“我的结尾是一个换行符，用于传输半包粘包处理”\r\n");

			f.channel().closeFuture().syncUninterruptibly();


		} catch (Exception e) {

		} finally {
			workGroup.shutdownGracefully();
		}


	}
}
