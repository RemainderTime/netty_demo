package com.xf.newdemo06;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * packageName com.xf.newdemo06
 *
 * @author remaindertime
 * @className ServerHandler
 * @date 2024/9/20
 * @description
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //接收消息
        System.out.println("服务端接收到客户端消息---");
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器收到消息：" + byteBuf.toString(StandardCharsets.UTF_8));

        //发送响应消息
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes("我成功收到了你的消息~~~".getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(buffer);
    }
}
