package com.pan.note.system.controller.publicApi;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pan.note.system.entity.Books;
import com.pan.note.system.entity.Categories;
import com.pan.note.system.entity.Notes;
import com.pan.note.system.service.impl.BooksServiceImpl;
import com.pan.note.system.service.impl.CategoriesServiceImpl;
import com.pan.note.system.service.impl.NotesServiceImpl;
import com.pan.note.system.util.DTO;
import com.pan.note.system.util.Json;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 级联菜单
 */
@Controller
@RequestMapping("/cascade")
public class CascadeController {

    @Autowired
    CategoriesServiceImpl categoriesService;

    @Autowired
    NotesServiceImpl notesService;

    @Autowired
    BooksServiceImpl booksService;

    /*通过一级id*/
    @RequestMapping("/notes")
    @ResponseBody
    public Json getNotesCascade(@RequestBody DTO dto){
        Json res = new Json();
        LambdaQueryWrapper<Categories> categoriesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Categories> eq = categoriesLambdaQueryWrapper.eq(Categories::getPid, dto.getPid())
                .eq(Categories::getDeleted,0)
                .eq(Categories::getUid,dto.getUid());
        List<Categories> cateList = categoriesService.list(eq);//二级菜单列表
        //通过二级菜单列表获取三级菜单列表
        List<Map<String,Object>> cacs = new ArrayList<>();

        for (Categories c : cateList){
            LambdaQueryWrapper<Notes> notesLambdaQueryWrapper = new LambdaQueryWrapper<>();
            LambdaQueryWrapper<Notes> eq1 = notesLambdaQueryWrapper.eq(Notes::getCategory, c.getId()).eq(Notes::getDeleted,0);
            List<Notes> notes = notesService.list(eq1);
            Map<String, Object> stringObjectMap = BeanUtil.beanToMap(c);
            stringObjectMap.put("notes",notes);
            cacs.add(stringObjectMap);
        }

        res.setState(true);
        res.setObj(cacs);
        return res;
    }

    /*通过一级id*/
    @RequestMapping("/books")
    @ResponseBody
    public Json getBooksCascade(@RequestBody DTO dto){
        Json res = new Json();
        LambdaQueryWrapper<Categories> categoriesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Categories> eq = categoriesLambdaQueryWrapper.eq(Categories::getPid, dto.getPid())
                .eq(Categories::getDeleted,0)
                .eq(Categories::getUid,dto.getUid());
        List<Categories> cateList = categoriesService.list(eq);//二级菜单列表
        //通过二级菜单列表获取三级菜单列表
        List<Map<String,Object>> cacs = new ArrayList<>();

        for (Categories c : cateList){
            System.out.println(c.getTitle());
            LambdaQueryWrapper<Books> booksLambdaQueryWrapper = new LambdaQueryWrapper<>();
            List<Books> notes = booksService.list(booksLambdaQueryWrapper.eq(Books::getCategory,c.getId()).eq(Books::getDeleted,0));
            Map<String, Object> stringObjectMap = BeanUtil.beanToMap(c);
            stringObjectMap.put("notes",notes);
            cacs.add(stringObjectMap);
        }

        res.setState(true);
        res.setObj(cacs);
        return res;
    }

}
