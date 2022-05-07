package com.pan.note.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pan.note.system.entity.Notes;
import com.pan.note.system.service.impl.NotesServiceImpl;
import com.pan.note.system.util.DTO;
import com.pan.note.system.util.Json;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    NotesServiceImpl notesService;

    @RequestMapping("/getNotes")
    public Json getNotes(@RequestParam("cid")Integer cid){
        Json resp = new Json();
        LambdaQueryWrapper<Notes> notesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Notes> eq = notesLambdaQueryWrapper.eq(Notes::getCategory, cid);
        List<Notes> list = notesService.list(eq);
        resp.setState(true);
        resp.setObj(list);
        return resp;

    }

    @RequestMapping("/getNote")
    public Json getNote(@RequestBody DTO dto){
        Json resp = new Json();
        LambdaQueryWrapper<Notes> notesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Notes> eq = notesLambdaQueryWrapper.eq(Notes::getId, dto.getId()).eq(Notes::getUid,dto.getUid());
        Notes one = notesService.getOne(eq);

        resp.setObj(one);
        resp.setState(true);
        return resp;
    }

    /*添加笔记*/
    @RequestMapping("/add")
    public Json addNote(@RequestBody Notes note){
        Json resp = new Json();
        int res = notesService.add(note);

        if (res>0){
            resp.setState(true);
            resp.setObj(note);
            resp.setMsg("添加成功！");
            return resp;
        }
        resp.setState(false);
        resp.setMsg("添加失败");
        return resp;
    }


    /*更新笔记*/

    @RequestMapping("/update")
    public  Json updateNote(@RequestBody Notes note){

        Json resp = new Json();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        note.setLastModifyDate(simpleDateFormat.format(new Date()));
        String content = note.getContent();
        char[] chars = content.toCharArray();
        note.setTextCount(chars.length);
        LambdaQueryWrapper<Notes> notesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        boolean update = notesService.update(note, notesLambdaQueryWrapper.eq(Notes::getId, note.getId()));
        if (!update){
            resp.setState(false);
            resp.setMsg("更新失败");
            return resp;
        }
        Notes one = notesService.getOne(notesLambdaQueryWrapper.eq(Notes::getId, note.getId()));
        System.out.println(one);
        resp.setState(true);
        resp.setMsg("更新成功");
        resp.setObj(one);
        return resp;
    }

}
