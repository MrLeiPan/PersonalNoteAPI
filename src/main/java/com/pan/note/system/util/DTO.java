package com.pan.note.system.util;

import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDate;

/**
 * 请求参数
 */
@Data
public class DTO {
    private Integer uid;//用户id
    private Integer pid;//父级id
    private Integer id;
    private String title;
    private String username;
    private String password;

    private String nickname;

    private Integer gender;

    private LocalDate birth;

    private String email;

    private String labels;

    private String introduce;

    private String major;

    private String phone;

}
