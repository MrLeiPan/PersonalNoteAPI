package com.pan.note.mychat.netty.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @auth0r Mao
 * @date 2021/9/10 23:03
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChatMsg implements Serializable {
    //消息id
    private Long massageId;
    //发送者id
    private Long senderId;
    //接收者Id
    private Long receiverId;
    //消息内容
    private String massage;

}
