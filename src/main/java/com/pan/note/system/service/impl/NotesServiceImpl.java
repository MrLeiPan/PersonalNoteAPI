package com.pan.note.system.service.impl;

import com.pan.note.system.entity.Notes;
import com.pan.note.system.mapper.NotesMapper;
import com.pan.note.system.service.INotesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@Service
public class NotesServiceImpl extends ServiceImpl<NotesMapper, Notes> implements INotesService {

    @Resource
    @Autowired
    NotesMapper notesMapper;

    @Override
    public int add(Notes note) {
        String createDate = note.getCreateDate();
        String reDate = createDate.replace("/", "-");
        note.setCreateDate(reDate);
        note.setLastModifyDate(reDate);
        return notesMapper.insert(note);
    }
}
