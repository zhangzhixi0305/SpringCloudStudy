package com.zhixi.service;

import com.zhixi.pojo.User;

/**
 * @ClassName IUserService
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:41
 * @Version 1.0
 */
public interface UserService {
    User getUserById(int uid);
}
