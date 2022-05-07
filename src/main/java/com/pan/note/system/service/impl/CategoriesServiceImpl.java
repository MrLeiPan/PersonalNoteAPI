package com.pan.note.system.service.impl;

import com.pan.note.system.entity.Categories;
import com.pan.note.system.mapper.CategoriesMapper;
import com.pan.note.system.service.ICategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements ICategoriesService {

    @Resource
    @Autowired
    CategoriesMapper categoriesMapper;

    /**
     * 添加目录
     * @param categories
     * @return
     */
    @Override
    public int add(Categories categories) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        categories.setCreateDate(simpleDateFormat.format(new Date()));//添加创建时间

        return categoriesMapper.insert(categories);
    }
}
