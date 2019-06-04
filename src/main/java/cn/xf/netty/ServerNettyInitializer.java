package cn.xf.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * 初始化器，channel注册之后会执行里面的相应的初始化方法
 */
public class ServerNettyInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel channel) throws Exception {
        //通过SocketChannel获取相应的管道
        ChannelPipeline pipeline=channel.pipeline();
        //通过管道，添加handler
        //HttpServerCodec使用Netty提供的助手类，可以理解为拦截器
        //当请求到服务器，需要进行解码，响应到客户端编码
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());
        //添加自定义的助手类，返回“hello netty”
        pipeline.addLast("customHandler",new CustomHandler());
    }
}
