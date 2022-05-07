package com.pan.note.mychat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mao
 * @date 2021/9/13 11:43
 */
@Component
public class WebSocketServer implements Runnable {

    @Autowired
    private NettyChannelInitializer nettyChannelInitializer;

    @Override
    public void run() {

        NioEventLoopGroup bossGroup  = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup  = new NioEventLoopGroup();

        try{
            new ServerBootstrap()
                    .group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(nettyChannelInitializer)

                    .bind(8099).sync()
                    .channel().closeFuture().sync();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
