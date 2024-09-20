package com.xf.newdemo06;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

/**
 * packageName com.xf.newdemo06
 *
 * @author remaindertime
 * @className ClientHandler
 * @date 2024/9/20
 * @description
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接成功");
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes("你好，我是客户端".getBytes());
        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端收到响应消息：" + byteBuf.toString(StandardCharsets.UTF_8));
    }
}
