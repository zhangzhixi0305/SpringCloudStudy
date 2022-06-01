package com.zhixi.mapper;

import com.zhixi.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName BookMapper
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:52
 * @Version 1.0
 */
@Mapper
public interface BookMapper {

    @Select("select * from DB_BOOK where bid = #{bid}")
    Book getBookById(int bid);
}
