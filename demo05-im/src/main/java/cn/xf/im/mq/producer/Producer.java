package cn.xf.im.mq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @ClassName: Producer
 * @Author: xiongfeng
 * @Date: 2023/5/12 14:40
 * @Version: 1.0
 */
@Component
public class Producer {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void produce() {
		String message = new Date() + "Beijing";
		System.out.println("生产者产生消息=====" + message);
		rabbitTemplate.convertAndSend("amq.direct", null, message);
	}
}