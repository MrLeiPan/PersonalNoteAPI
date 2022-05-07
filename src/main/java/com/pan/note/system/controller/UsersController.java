package com.pan.note.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pan.note.system.entity.Users;
import com.pan.note.system.service.impl.UsersServiceImpl;
import com.pan.note.system.util.DTO;
import com.pan.note.system.util.Json;
import com.pan.note.system.util.JwtUtil;
import com.pan.note.system.util.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersServiceImpl usersService;

    @RequestMapping("/login")
    public Json login(@RequestBody DTO dto){
        Json resp = new Json();
        LambdaQueryWrapper<Users> usersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Users user = usersService.getOne(usersLambdaQueryWrapper.eq(Users::getUsername, dto.getUsername()).eq(Users::getPassword, dto.getPassword()));
        //准备存放在JWT中的自定义数据
        if (user==null){
            resp.setState(false);
            resp.setMsg("不存在该用户或者密码错误");
            return resp;
        }
        user.setPassword("*******");
        Map<String, Object> info = new HashMap<>();
        info.put("username", user.getUsername());
        info.put("password", user.getPassword());

        //生成JWT字符串
        String token = JwtUtil.sign(String.valueOf(user.getId()), info);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfo.setToken(token);
        resp.setMsg("登录成功！");
        resp.setState(true);
        resp.setObj(userInfo);
        return resp;

    }

    /**
     * 注册用户
     * @return
     */
    @RequestMapping("/register")
    public Json register(@RequestBody DTO dto){

        //先判断用户名是否存在
        Json resp = new Json();
        Users user = new Users();
        LambdaQueryWrapper<Users> usersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Users one = usersService.getOne(usersLambdaQueryWrapper.eq(Users::getUsername, dto.getUsername()));
        if (one!=null){
            resp.setState(false);
            resp.setMsg("用户名已存在");
            return resp;
        }
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setMajor(dto.getMajor());
        user.setPhone(dto.getPhone());
        boolean save = usersService.save(user);
        if (!save){
            resp.setState(false);
            resp.setMsg("注册失败");
            return resp;
        }

        resp.setState(true);
        resp.setMsg("注册成功");
        resp.setObj(user);
        return resp;
    }
}
