package cn.xf.netty;

import cn.xf.netty.server.NettyServer;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

/**
 * @Description: ${description}
 * @ClassName: ${NAME}
 * @Author: xiongfeng
 * @Date: ${DATE} ${TIME}
 * @Version: 1.0
 */

@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

		@Value("${netty.host}")
		private String host;
		@Value("${netty.port}")
		private int port;
		@Autowired
		private NettyServer nettyServer;

		public static void main(String[] args) {
			SpringApplication.run(NettyApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			InetSocketAddress address = new InetSocketAddress(host, port);
			ChannelFuture channelFuture = nettyServer.bing(address);
			Runtime.getRuntime().addShutdownHook(new Thread(() -> nettyServer.destroy()));
			channelFuture.channel().closeFuture().syncUninterruptibly();
		}
}