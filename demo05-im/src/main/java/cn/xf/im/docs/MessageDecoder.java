package cn.xf.im.docs;

import cn.xf.im.domain.Message;
import cn.xf.im.domain.MessageHeader;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Description: 自定义编码协议
 * @ClassName: MessgeDecoder
 * @Author: xiongfeng
 * @Date: 2023/5/10 16:37
 * @Version: 1.0
 */
public class MessageDecoder extends ByteToMessageDecoder {
	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {

		/** 获取command*/
		int command = in.readInt();

		/** 获取version*/
		int version = in.readInt();

		/** 获取clientType*/
		int clientType = in.readInt();

		/** 获取clientType*/
		int messageType = in.readInt();

		/** 获取appId*/
		int appId = in.readInt();

		/** 获取imeiLength*/
		int imeiLength = in.readInt();

		/** 获取bodyLen*/
		int bodyLen = in.readInt();

		if (in.readableBytes() < imeiLength + bodyLen) {
			in.resetReaderIndex();
			return;
		}

		byte[] imei = new byte[imeiLength];
		in.readBytes(imei);

		byte[] msgBody = new byte[bodyLen];
		in.readBytes(msgBody);

		String imeiS = new String(imei);

		//设置请求头
		MessageHeader messageHeader = new MessageHeader();
		messageHeader.setAppId(appId);
		messageHeader.setClientType(clientType);
		messageHeader.setCommand(command);
		messageHeader.setLength(bodyLen);
		messageHeader.setVersion(version);
		messageHeader.setMessageType(messageType);
		messageHeader.setImei(imeiS);

		Message message = new Message();
		message.setMessageHeader(messageHeader);

		if (messageType == 1) {
			String msgBodyS = new String(msgBody);
			JSONObject json = JSONObject.parseObject(msgBodyS);
			//设置请求数据
			message.setMessagePack(json);
		}
		list.add(message);
	}
}
