package cn.xf.netty.server;

import cn.xf.netty.utils.MsgUtil;
import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateEvent;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @ClassName: MyClientHandler
 * @Author: xiongfeng
 * @Date: 2023/5/6 08:17
 * @Version: 1.0
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

	private static List<SocketChannel> socketChannelList = new ArrayList<>();

	/**
	 * 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SocketChannel channel = (SocketChannel) ctx.channel();
		System.out.println("链接报告开始");
		System.out.println("链接报告信息：有一客户端链接到本服务端。channelId：" + channel.id());
		System.out.println("链接报告IP:" + channel.localAddress().getHostString());
		System.out.println("链接报告Port:" + channel.localAddress().getPort());
		System.out.println("链接报告完毕");
		//通知客户端链接建立成功
		String str = "通知客户端链接建立成功" + " " + new Date() + " " + channel.localAddress().getHostString() + "\r\n";

		socketChannelList.add(channel);

		socketChannelList.forEach(e -> {
			if (channel != e) {
				e.writeAndFlush("通知：" + channel.remoteAddress() + " 上线了~~~");
			}
		});

//		ctx.writeAndFlush(MsgUtil.buildMsg(channel.id().toString(), str));
	}

	/**
	 * 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {


		socketChannelList.forEach(e -> {
			if (ctx.channel() != e) {
				e.writeAndFlush("通知：" + ctx.channel().remoteAddress() + "下线了~~~");
			}
		});
		System.out.println("客户端断开链接" + ctx.channel().localAddress().toString());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		//接收msg消息{与上一章节相比，此处已经不需要自己进行解码}
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + msg.getClass());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息内容：" + JSON.toJSONString(msg));

		SocketChannel channel = (SocketChannel) ctx.channel();
		for (SocketChannel e : socketChannelList) {
			if (channel != e) {
				e.writeAndFlush("群聊消息" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "-" + ctx.channel().remoteAddress() + ":\n" + JSON.toJSONString(msg));
			}
		}

	}

	/**
	 * 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		System.out.println("异常信息：\r\n" + cause.getMessage());
	}


	/**
	 * 客户端事件触发
	 * @param ctx
	 * @param evt
	 * @throws Exception
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

		IdleStateEvent event= (IdleStateEvent) evt;
		if(event == IdleStateEvent.READER_IDLE_STATE_EVENT){
			ctx.channel().writeAndFlush("超时了断开连接~~~~");
			ctx.close();
		}


	}
}
