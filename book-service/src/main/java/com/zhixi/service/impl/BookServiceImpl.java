package com.zhixi.service.impl;

import com.zhixi.mapper.BookMapper;
import com.zhixi.pojo.Book;
import com.zhixi.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName BookServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:54
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements IBookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}
