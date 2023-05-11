package cn.xf.im.utils;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description: redis工具工具类
 * @ClassName: RedissionUtil
 * @Author: xiongfeng
 * @Date: 2023/5/11 11:38
 * @Version: 1.0
 */

@Component
public class RedissonUtil {

	@Autowired
	private static RedissonClient redissonClient;

	public static RedissonClient getRedissonClient(){
		return redissonClient;
	}
}
