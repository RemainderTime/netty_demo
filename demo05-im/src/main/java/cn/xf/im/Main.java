package cn.xf.im;

import cn.xf.im.config.GlobalSetting;
import cn.xf.im.register.RegistryZK;
import cn.xf.im.register.ZKit;
import cn.xf.im.server.NettyServer;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description: ${description}
 * @ClassName: ${NAME}
 * @Author: xiongfeng
 * @Date: ${DATE} ${TIME}
 * @Version: 1.0
 */

@SpringBootApplication
public class Main implements CommandLineRunner {

	@Value("${netty.server.port}")
	private Integer nettyPort;

	@Value("${zookeeper.zkServers}")
	private String zkServers;

	@Value("${zookeeper.connectionTimeout}")
	private Integer connectionTimeout;

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}

	@Override
	public void run(String... args) throws Exception {
		NettyServer nettyServer = new NettyServer();
		nettyServer.start(nettyPort);

		//装配zookeeper
		String hostAddress = InetAddress.getLocalHost().getHostAddress();
		ZkClient zkClient = new ZkClient(zkServers,
				connectionTimeout);
		ZKit zKit = new ZKit(zkClient);
		RegistryZK registryZK = new RegistryZK(zKit, hostAddress);
		Thread thread = new Thread(registryZK);
		thread.start();
	}


}