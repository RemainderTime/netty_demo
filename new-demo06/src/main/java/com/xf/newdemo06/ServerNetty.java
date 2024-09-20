package com.xf.newdemo06;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * packageName com.xf.newdemo06
 *
 * @author remaindertime
 * @className ServerNetty
 * @date 2024/9/20
 * @description
 */
public class ServerNetty {

    private int port;

    public ServerNetty(int port) {
        this.port = port;
    }

    public void run() {
        // 启动Netty服务器
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ServerHandler());
                        }
                    });
            //绑定端口
            ChannelFuture future = bootstrap.bind(port);
            //监听启动状态
            future.addListener(future1 -> {
                if (future1.isSuccess()) {
                    System.out.println("服务器启动成功");
                } else {
                    {
                        System.out.println("服务器启动失败");
                    }
                }
            });
            future.sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        ServerNetty server = new ServerNetty(8080);
        server.run();
    }
}
