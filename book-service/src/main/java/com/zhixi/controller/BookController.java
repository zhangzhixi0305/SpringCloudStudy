package com.zhixi.controller;

import com.zhixi.pojo.Book;
import com.zhixi.service.IBookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName BookController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:55
 * @Version 1.0
 */
@RestController
public class BookController {

    @Resource
    IBookService service;

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid) {
        return service.getBookById(bid);
    }
}
