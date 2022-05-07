package com.pan.note.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pan.note.system.entity.Books;
import com.pan.note.system.mapper.BooksMapper;
import com.pan.note.system.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

    private BooksMapper booksMapper;

    @Autowired
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    List<Books> getAll(){
        return booksMapper.selectList(new QueryWrapper<>());
    }
    Books getByName(){
        LambdaQueryWrapper<Books> wrapper= new LambdaQueryWrapper<>();
        wrapper.eq(Books::getTitle,"aa");

        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("b_title","a");
        return booksMapper.selectOne(wrapper);
    }

}
