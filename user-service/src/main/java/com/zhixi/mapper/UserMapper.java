package com.zhixi.mapper;

import com.zhixi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserMapper
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:42
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);
}
