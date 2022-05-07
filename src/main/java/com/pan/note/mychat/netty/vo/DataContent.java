package com.pan.note.mychat.netty.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @auth0r Mao
 * @date 2021/9/10 22:59
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class DataContent implements Serializable {

    //活动
    private Integer action;
    //消息内容

    private ChatMsg chatMsg;
    //拓展
    private String extend;




}
