package com.pan.note.system.service.impl;

import com.pan.note.system.entity.Users;
import com.pan.note.system.mapper.UsersMapper;
import com.pan.note.system.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
