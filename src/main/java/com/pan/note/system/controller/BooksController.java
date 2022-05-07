package com.pan.note.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pan.note.system.entity.Books;
import com.pan.note.system.entity.Notes;
import com.pan.note.system.service.impl.BooksServiceImpl;
import com.pan.note.system.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Pan
 * @since 2022-04-23
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksServiceImpl booksService;



}
