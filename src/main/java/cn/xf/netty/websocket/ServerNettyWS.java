package cn.xf.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * websocket通信
 */
public class ServerNettyWS {

    public static void main(String[] args)throws Exception{

        EventLoopGroup mainGroup=new NioEventLoopGroup();

        EventLoopGroup childGroup=new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();

            serverBootstrap.group(mainGroup,childGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(null);

            ChannelFuture future = serverBootstrap.bind(9999).sync();

            future.channel().closeFuture().sync();
        }finally {
            childGroup.shutdownGracefully();
            mainGroup.shutdownGracefully();
        }
    }
}
