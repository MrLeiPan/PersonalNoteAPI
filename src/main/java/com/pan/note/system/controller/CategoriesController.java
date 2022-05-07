package com.pan.note.system.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pan.note.system.entity.Categories;
import com.pan.note.system.service.impl.CategoriesServiceImpl;
import com.pan.note.system.util.DTO;
import com.pan.note.system.util.Json;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@RestController
@RequestMapping("/categories")
public class CategoriesController {


    @Autowired
    CategoriesServiceImpl categoriesService;

    @RequestMapping("/category")
    public Json getCategories(@RequestBody DTO dto){
        Json res = new Json();
        System.out.println(dto);
        LambdaQueryWrapper<Categories> categoriesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Categories> eq = categoriesLambdaQueryWrapper.eq(Categories::getPid, dto.getPid());
        List<Categories> list = categoriesService.list(eq);
        res.setState(true);
        res.setObj(list);
        return res;
    }

    /**
     * 添加二级菜单
     * @return
     */
    @RequestMapping("add")
    public Json addCategory(@RequestBody DTO dto){
        Json resp = new Json();

        Categories categories = new Categories();
        categories.setPid(dto.getPid());
        categories.setTitle(dto.getTitle());
        categories.setUid(dto.getUid());
        int res = categoriesService.add(categories);
        if (res>0){
            resp.setState(true);
            resp.setObj(categories);
            return resp;
        }
        resp.setState(false);
        return resp;
    }

    /**
     * 跟据id，删除主题
     * @return
     */
    @RequestMapping("/delete")
    public Json delete(@RequestBody DTO dto){
        Json resp = new Json();

        LambdaQueryWrapper<Categories> categoriesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Categories categories = new Categories();
        categories.setDeleted(1);
        boolean update = categoriesService.update(categories,categoriesLambdaQueryWrapper.eq(Categories::getId, dto.getId()).eq(Categories::getUid,dto.getUid()));
        if (update){
            resp.setState(true);
            resp.setMsg("删除成功！");
            return resp;
        }
        resp.setState(false);
        resp.setMsg("删除失败！");

        return resp;
    }
}
