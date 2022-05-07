package com.pan.note.mychat.netty.vo;

/**
 * @auth0r Mao
 * @date 2021/9/10 23:15
 */
public enum MsgActionEnum {

    CONNECT(1,"第一次(或重连)初始化链接"),
    CHAT(2,"聊天消息"),
    SIGNED(3,"消息签收"),
    KEEPALIVE(4,"客户端保持心跳"),
    PULL_FRIEND(5,"拉去好友");

    public int type;
    public String content;

    MsgActionEnum(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public static MsgActionEnum getEnumByType(int type){
        for (MsgActionEnum value : MsgActionEnum.values()) {
            if(value.type == type){
                return value;
            }
        }
        return null;
    }
}
