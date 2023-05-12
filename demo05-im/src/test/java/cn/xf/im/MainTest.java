package cn.xf.im;

import cn.xf.im.mq.producer.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @ClassName: MainTest
 * @Author: xiongfeng
 * @Date: 2023/5/12 14:47
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

	@Autowired
	Producer producer;
	@Test
	public void testProduceObj() throws InterruptedException {
		producer.produce();
		Thread.sleep(1*1000);
	}
}