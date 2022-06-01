package com.zhixi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.UserBorrowDetail;
import com.zhixi.service.IBorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @ClassName BorrowController
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:50
 * @Version 1.0
 */
@RestController
public class BorrowController {

    @Resource
    IBorrowService service;

    /**
     * 根据用户ID查询出是哪个用户借阅了哪些书籍
     *
     * @param uid 用户id
     * @return 用户借阅的书籍
     */
    @HystrixCommand(fallbackMethod = "onError")    //服务降级：使用@HystrixCommand来指定备选方案
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    /**
     * 备选方案，这里直接返回空列表了
     * 注意参数和返回值要和上面的一致
     *
     * @param uid 用户id
     * @return 空的数据
     */
    UserBorrowDetail onError(@PathVariable("uid") int uid) {
        System.out.println("执行补救措施");
        return new UserBorrowDetail(null, new ArrayList<>());
    }

    /**
     * 根据用户id和书籍id获取借阅记录
     *
     * @param uid 用户id
     * @param bid 书籍id
     * @return 借阅记录
     */
    @RequestMapping("/borrow/{uid}/{bid}")
    public Borrow getBorrowToUidBid(@PathVariable("uid") int uid, @PathVariable("bid") int bid) {
        return service.getBorrowToUidBid(uid, bid);
    }
}
