package com.zhixi.controller;

import com.zhixi.pojo.User;
import com.zhixi.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 18:44
 * @Version 1.0
 */
@RestController
public class UserController {

    @Resource
    UserService service;

    /**
     * 这里以RESTFul风格为例
     * @param uid 用户id
     * @return 用户信息
     */
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid) {
        return service.getUserById(uid);
    }
}
