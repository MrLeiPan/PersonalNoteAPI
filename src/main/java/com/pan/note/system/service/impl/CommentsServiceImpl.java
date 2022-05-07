package com.pan.note.system.service.impl;

import com.pan.note.system.entity.Comments;
import com.pan.note.system.mapper.CommentsMapper;
import com.pan.note.system.service.ICommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
