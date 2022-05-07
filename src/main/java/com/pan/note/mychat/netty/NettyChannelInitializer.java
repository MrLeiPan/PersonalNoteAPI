package com.pan.note.mychat.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.stereotype.Component;


/**
 * @author Mao
 * @date 2021/9/13 12:36
 */
@Component
@ChannelHandler.Sharable
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //添加http编码器
        pipeline.addLast(new HttpServerCodec());
        //以块的方式写 对写大数据流进行支持
        pipeline.addLast(new ChunkedWriteHandler());
        /**
         * 当浏览器发送大量请求时，就会发送多次HTTP请求
         * 将多个HTTP请求聚合起来
         */
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //自定义handler，处理业务逻辑
        pipeline.addLast(new ChatTextWebSocketFrameHandler());
    }
}
