package com.pan.note.system.util;


import com.pan.note.system.entity.Books;
import lombok.Data;

/**
 * 封装返回bean
 */

@Data
public class Json {
    private Object obj; //返回的对象
    private String msg;//返回的消息
    private Boolean state;//返回状态

}
