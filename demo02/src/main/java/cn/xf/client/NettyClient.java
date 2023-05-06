package cn.xf.client;

import cn.xf.util.MsgUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Description:
 * @ClassName: NettyClient
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:18
 * @Version: 1.0
 */
public class NettyClient {

	public static void main(String[] args) {
		new NettyClient().connect("127.0.0.1", 7397);
	}

	public void connect(String host, int port) {

		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workGroup)
					.channel(NioSocketChannel.class)
					.option(ChannelOption.AUTO_READ, true)
					.handler(new MyChannelInitializer());

			ChannelFuture f = b.connect(host, port).sync();
			//
			f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(),"你好，使用protobuf通信格式的服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取案例源码。"));
			f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(),"你好，使用protobuf通信格式的服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取案例源码。"));
			f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(),"你好，使用protobuf通信格式的服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取案例源码。"));
			f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(),"你好，使用protobuf通信格式的服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取案例源码。"));
			f.channel().writeAndFlush(MsgUtil.buildMsg(f.channel().id().toString(),"你好，使用protobuf通信格式的服务端，我是https://bugstack.cn博主，付政委。这是我的公众号<bugstack虫洞栈>，关注我获取案例源码。"));

			f.channel().closeFuture().syncUninterruptibly();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workGroup.shutdownGracefully();
		}

	}
}
