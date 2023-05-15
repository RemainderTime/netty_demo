package cn.xf.im.utils;

import cn.xf.im.mq.consumer.UserLoginMessageListener;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description: redis工具工具类
 * @ClassName: RedissionUtil
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:38
 * @Version: 1.0
 */

@Configuration
public class RedissonUtil {

	@Value("${redisson.address}")
	private static String address;
	@Value("${redisson.database}")
	private static Integer database;
	@Value("${redisson.password}")
	private static String password;

	private static RedissonClient redissonClient;

	public static RedissonClient getRedissonClient() {
		return redissonClient;
	}

	public static void init(Integer loginType) {
		Config config = new Config();
		config.useSingleServer().setAddress("redis://120.48.109.209:6379");
		config.useSingleServer().setDatabase(0);
		config.useSingleServer().setConnectTimeout(5000);
//		config.useSingleServer().setPassword("123456");
		redissonClient = Redisson.create(config);
		UserLoginMessageListener userLoginMessageListener = new UserLoginMessageListener(loginType);
		userLoginMessageListener.listenerUserLogin();
	}
}
