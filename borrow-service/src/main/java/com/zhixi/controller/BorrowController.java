package com.zhixi.controller;

import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.UserBorrowDetail;
import com.zhixi.service.IBorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
     * @param uid 用户id
     * @return 用户借阅的书籍
     */
    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid) {
        return service.getUserBorrowDetailByUid(uid);
    }

    /**
     * 根据用户id和书籍id获取借阅记录
     * @param uid 用户id
     * @param bid 书籍id
     * @return 借阅记录
     */
    @RequestMapping("/borrow/{uid}/{bid}")
    public Borrow getBorrowToUidBid(@PathVariable("uid") int uid,@PathVariable("bid") int bid){
        return service.getBorrowToUidBid(uid, bid);
    }
}
