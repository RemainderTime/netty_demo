package cn.xf.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientUpgradeHandler;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author RemainderTime
 * @date 2019/6/3 23:14
 */
public class ServerHettyWSInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();

        //websocket 基于http协议 所以要用http编解码器
        pipeline.addLast(new HttpServerCodec());
        //对写大数据流的支持
        pipeline.addLast(new ChunkedWriteHandler());
        //对httpMessage进行聚合， 聚合成FullHttpRequest或者FullHttpResponse
        //几乎在Netty中编程，都会使用到此handler
        pipeline.addLast(new HttpObjectAggregator(1024*64));

        //======================以上是用于支持http协议===================
        /**
         * websocket 服务器处理协议 用于指定的客户端连接访问的路由：、ws
         * 本handler 会帮助处理一些繁重复杂的事
         * 会帮你处理握手动作：handshakeing(close,ping,pong) ping +pong=心跳
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast(null);

    }
}
