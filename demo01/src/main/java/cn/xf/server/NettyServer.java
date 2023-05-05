package cn.xf.server;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

/**
 * @Description:
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/5 16:11
 * @Version: 1.0
 */

@Component("nettyServer")
public class NettyServer {

	private Logger logger = LoggerFactory.getLogger(NettyServer.class);

	/**
	 * 配置服务端Nio线程组
	 */
	private final EventLoopGroup parentGroup = new NioEventLoopGroup();
	private final EventLoopGroup childGroup = new NioEventLoopGroup();

	private Channel channel;

	public ChannelFuture bing(InetSocketAddress address) {
		ChannelFuture channelFuture = null;
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(parentGroup, childGroup)
					.channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 128)
					.childHandler(new MyChannelInitializer());
			channelFuture = b.bind(address).syncUninterruptibly();
			channel = channelFuture.channel();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != channelFuture && channelFuture.isSuccess()) {
				logger.debug("itstack-demo-netty server start done. ");
			} else {
				logger.error("itstack-demo-netty server start error.");
			}

		}

		return channelFuture;
	}

	public void destroy() {
		if (null == channel) return;
		channel.close();
		parentGroup.shutdownGracefully();
		childGroup.shutdownGracefully();
	}

	public Channel getChannel() {
		return channel;
	}
}
