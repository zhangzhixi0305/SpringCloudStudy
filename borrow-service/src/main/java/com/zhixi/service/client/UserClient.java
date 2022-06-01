package com.zhixi.service.client;

import com.zhixi.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserClitnt
 * @Author zhangzhixi
 * @Description 声明为userservice服务的HTTP请求客户端
 * @Date 2022-6-1 8:45
 * @Version 1.0
 */
@FeignClient("userservice")
public interface UserClient {

    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid") int uid);
}
