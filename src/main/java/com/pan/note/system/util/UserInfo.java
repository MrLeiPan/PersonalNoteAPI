package com.pan.note.system.util;

import com.pan.note.system.entity.Users;
import lombok.Data;

@Data
public class UserInfo {
    private Users user;
    private String token;

}
