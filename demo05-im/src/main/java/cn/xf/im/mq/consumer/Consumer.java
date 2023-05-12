package cn.xf.im.mq.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @ClassName: Consumer
 * @Author: xiongfeng
 * @Date: 2023/5/12 14:39
 * @Version: 1.0
 */
@Component
public class Consumer {
	@RabbitHandler
	@RabbitListener(queuesToDeclare = @Queue("netty-queue"))
	public void process(String message) {
		System.out.println("消费者消费消息111=====" + message);
	}
}
