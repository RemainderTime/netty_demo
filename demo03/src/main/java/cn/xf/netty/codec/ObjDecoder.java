package cn.xf.netty.codec;

import cn.xf.netty.utils.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @Description:
 * @ClassName: ObjDecoder
 * @Author: xiongfeng
 * @Date: 2023/5/6 11:13
 * @Version: 1.0
 */
public class ObjDecoder extends ByteToMessageDecoder {

	private Class<?> genericClass;

	public ObjDecoder(Class<?> genericClass) {
		this.genericClass = genericClass;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
		if (in.readableBytes() < 4) {
			return;
		}
		in.markReaderIndex();
		int dataLength = in.readInt();
		if (in.readableBytes() < dataLength) {
			in.resetReaderIndex();
			return;
		}
		byte[] data = new byte[dataLength];
		in.readBytes(data);
		out.add(SerializationUtil.deserialize(data, genericClass));
	}

}
