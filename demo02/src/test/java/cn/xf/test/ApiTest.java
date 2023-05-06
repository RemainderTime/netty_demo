package cn.xf.test;

import cn.xf.domain.MsgBody;
import com.googlecode.protobuf.format.JsonFormat;

/**
 * @Description:
 * @ClassName: ApiTest
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:48
 * @Version: 1.0
 */
public class ApiTest {

	public static void main(String[] args) throws JsonFormat.ParseException {
		MsgBody.Builder msg = MsgBody.newBuilder();
		msg.setChannelId("abD01223");
		msg.setMsgInfo("hi helloworld");
		MsgBody msgBody = msg.build();

		//protobuf转Json 需要引入protobuf-java-format
		String msgBodyStr = JsonFormat.printToString(msgBody);
		System.out.println(msgBodyStr);

		//json转protobuf 需要引入protobuf-java-format
		JsonFormat.merge("{\"channelId\": \"HBdhi993\",\"msgInfo\": \"hi bugstack虫洞栈\"}", msg);
		msgBody = msg.build();
		System.out.println(msgBody.getChannelId());
		System.out.println(msgBody.getMsgInfo());

	}

}
