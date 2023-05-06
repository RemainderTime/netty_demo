package cn.xf.netty.codec;

import cn.xf.netty.utils.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description:
 * @ClassName: ObjEncoder
 * @Author: xiongfeng
 * @Date: 2023/5/6 11:13
 * @Version: 1.0
 */
public class ObjEncoder extends MessageToByteEncoder {

	private Class<?> genericClass;

	public ObjEncoder(Class<?> genericClass) {
		this.genericClass = genericClass;
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out)  {
		if (genericClass.isInstance(in)) {
			byte[] data = SerializationUtil.serialize(in);
			out.writeInt(data.length);
			out.writeBytes(data);
		}
	}
}
