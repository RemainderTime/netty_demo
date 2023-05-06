package cn.xf.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description:
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:27
 * @Version: 1.0
 */
public class NettyServer {

	public static void main(String[] args) {
		new NettyServer().bing(7397);
	}

	public void bing(int port) {

		EventLoopGroup parentGroup = new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(parentGroup, childGroup);
			b.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 128)
					.childHandler(new MyChannelInitializer());

			ChannelFuture channelFuture = b.bind(port).sync();

			channelFuture.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}

	}
}
