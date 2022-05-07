package com.pan.note.system.service;

import com.pan.note.system.entity.Notes;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
public interface INotesService extends IService<Notes> {

    /**
     * 添加
     * @param note
     * @return
     */
    public int add(Notes note);
}
