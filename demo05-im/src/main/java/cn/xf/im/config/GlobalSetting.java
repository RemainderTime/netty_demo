package cn.xf.im.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @ClassName: GlobalStting
 * @Author: xiongfeng
 * @Date: 2023/5/10 16:59
 * @Version: 1.0
 */

@ConfigurationProperties(prefix = "netty")
@Configuration
@Component
@Data
public class GlobalSetting {

	@Value("${server.port}")
	public int baseServerPort;
}
