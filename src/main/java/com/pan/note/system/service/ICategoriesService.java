package com.pan.note.system.service;

import com.pan.note.system.entity.Categories;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
public interface ICategoriesService extends IService<Categories> {


    /**
     * 添加目录
     * @param categories
     * @return
     */
    public int add(Categories categories);

}
