package cn.xf.im;

import cn.xf.im.server.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: ${description}
 * @ClassName: ${NAME}
 * @Author: xiongfeng
 * @Date: ${DATE} ${TIME}
 * @Version: 1.0
 */

@SpringBootApplication
public class Main implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}

	@Override
	public void run(String... args) throws Exception {
		NettyServer nettyServer =new NettyServer();
		nettyServer.start(9000);
	}

}