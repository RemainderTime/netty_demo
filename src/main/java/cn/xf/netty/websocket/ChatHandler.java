package cn.xf.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author RemainderTime
 * @date 2019/6/3 23:26
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    //用户记录和管理所有客户端的channel
    private static ChannelGroup clients=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected void channelRead0(ChannelHandlerContext context, TextWebSocketFrame frame) throws Exception {
        //接受客户端传输过来的消息
        String content=frame.text();
        System.out.println("接受到的数据："+content);

        for (Channel channel:clients){
            channel.writeAndFlush(new TextWebSocketFrame("[服务器在]"+ LocalDateTime.now()+"接受到的消息，消息为："+content));
        }
    }

    //

    /**
     * 当客户端连接服务端之后（打开连接）
     * 获取客户端的channel，并且放到channelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //当触发handlerRemoved,ChannelGroup会自动移除对应客户端的channel

        System.out.println("客户端断开，channel对应的长id为："+ctx.channel().id().asLongText());
        System.out.println("客户端断开，channel对应的短id为："+ctx.channel().id().asShortText());
    }
}
