package com.pan.note.mychat.netty;

import com.alibaba.fastjson.JSON;
import com.pan.note.mychat.netty.vo.DataContent;
import com.pan.note.mychat.netty.vo.MsgActionEnum;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 消息处理器
 * 来类用于出来消息的业务逻辑
 *
 * @author Mao
 * @date 2021/9/13 12:46
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class ChatTextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

//    private static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        Channel channel = ctx.channel();
        System.out.println("服务器收到消息 " + content);
        //消息内容转Java对象
        DataContent dataContent = JSON.parseObject(content, DataContent.class);
        System.out.println(dataContent);
        //获得对应的枚举类
        MsgActionEnum enumByType = MsgActionEnum.getEnumByType(dataContent.getAction().intValue());

        switch (enumByType) {
            case CONNECT:
                //将channel和发送者的关系保存起来
                Long senderId = dataContent.getChatMsg().getSenderId();
                UserChannelRel.put(senderId, channel);

                //打印全部
                UserChannelRel.manageDetail();
                break;
            case CHAT:
                //数据库保存操作
                //....
                Long receiverId = dataContent.getChatMsg().getReceiverId();
                //发送消息
                sendMsg(dataContent, receiverId);
                break;
            case SIGNED:

                break;
            case KEEPALIVE:

                break;
            case PULL_FRIEND:

                break;
            default:

        }
    }

    /**
     * 发送消息
     * @param dataContent 所需要发送的消息体
     * @param receiverId 需要发送的对象
     */
    private void sendMsg(DataContent dataContent, Long receiverId) {
        //判断用数是否在
        if (UserChannelRel.isOnline(receiverId)) {
            //用户在线
            Channel receiverChannel = UserChannelRel.get(receiverId);
            System.out.println(JSON.toJSONString(dataContent));
            receiverChannel.writeAndFlush(new TextWebSocketFrame(
                    JSON.toJSONString(dataContent)
            ));
        } else {
            //用户离线,写入数据库
            log.info("{}:用户离线",receiverId);
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        log.info("当前Channel建立链接：{}", channel.id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        UserChannelRel.remove(channel);
        log.info("{}：退出注册", channel.id().asLongText());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        log.error("异常发生：{}", cause.getMessage());
        Channel channel = ctx.channel();
        UserChannelRel.remove(channel);
        channel.close();
    }
}
