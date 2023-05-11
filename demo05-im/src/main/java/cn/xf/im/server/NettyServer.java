package cn.xf.im.server;

import cn.xf.im.config.GlobalSetting;
import cn.xf.im.docs.MessageDecoder;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;


/**
 * @Description:
 * @ClassName: NettyServer
 * @Author: xiongfeng
 * @Date: 2023/5/10 16:21
 * @Version: 1.0
 */
public class NettyServer {

	private static Logger logger = LoggerFactory.getLogger(NettyServer.class);

	private static EventLoopGroup parentGroup = null;
	private static EventLoopGroup childGroup = null;

	private static ServerBootstrap serverBootstrap = null;

//	@Autowired
//	private GlobalSetting globalSetting;

	public NettyServer() {

		parentGroup = new NioEventLoopGroup();
		childGroup = new NioEventLoopGroup();
		serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(parentGroup, childGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 10240)
				.option(ChannelOption.SO_REUSEADDR, true)
				.childOption(ChannelOption.SO_KEEPALIVE, true)
				.childOption(ChannelOption.TCP_NODELAY, true)
				.childHandler(new ChannelInitializer() {

					@Override
					protected void initChannel(Channel channel) throws Exception {

						ChannelPipeline pipeline = channel.pipeline();

						//自定义编码协议
						pipeline.addLast(new MessageDecoder());
						pipeline.addLast(new IdleStateHandler(2, 2, 10));
						pipeline.addLast(new HeartBeatHandler(3000L));
						pipeline.addLast(new MyServerHandler());
					}
				});

	}


	public void start(int port) {
		serverBootstrap.bind(port);
	}

	public static void main(String[] args) {
		GlobalSetting setting = new GlobalSetting();
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(setting.baseServerPort);
	}
}
