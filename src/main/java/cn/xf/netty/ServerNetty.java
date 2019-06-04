package cn.xf.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty服务类
 */
public class ServerNetty {
    public static void main(String[] args) throws  Exception{

        //创建一对线程池
        //主线程组，用于接受客户端的连接，但不做任何处理
        EventLoopGroup parentGroup=new NioEventLoopGroup();
        //子线程组，主线程组会把任务给它，进行任务的处理
        EventLoopGroup childGroup=new NioEventLoopGroup();
        try {
            //netty器的创建，serverBootstrap是一个启动类
            ServerBootstrap serverBootstrap=new ServerBootstrap();

            serverBootstrap.group(parentGroup,childGroup)//设置主从线程组
                    .channel(NioServerSocketChannel.class)//设置Nio通道
                    .childHandler(new ServerNettyInitializer());//子处理器,用于处理parentGroup
            //启动server，并设置端口号，同时启动方式为同步
            ChannelFuture channelFuture=serverBootstrap.bind(8888).sync();
            //监听关闭的channel，设置为同步方式
            channelFuture.channel().closeFuture().sync();
        } finally {
            parentGroup.shutdownGracefully();
        }


    }
}
