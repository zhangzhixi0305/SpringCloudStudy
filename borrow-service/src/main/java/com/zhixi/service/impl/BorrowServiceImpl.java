package com.zhixi.service.impl;

import com.zhixi.mapper.BorrowMapper;
import com.zhixi.pojo.Book;
import com.zhixi.pojo.Borrow;
import com.zhixi.pojo.User;
import com.zhixi.pojo.UserBorrowDetail;
import com.zhixi.service.IBorrowService;
import com.zhixi.service.client.BookClient;
import com.zhixi.service.client.UserClient;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BorrowServiceImpl
 * @Author zhangzhixi
 * @Description
 * @Date 2022-5-29 19:27
 * @Version 1.0
 */
@Service
public class BorrowServiceImpl implements IBorrowService {

    @Resource
    BorrowMapper mapper;

//    @Autowired
//    RestTemplate template;

    /**
     * 使用Feign风格进行服务调用
     */
    @Autowired
    BookClient bookClient;

    @Autowired
    UserClient userClient;

    /**
     * 获取某一个用户借阅的全部数据
     *
     * @param uid 用户ID
     * @return 用户借阅的全部数据
     */
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = mapper.getBorrowsByUid(uid);
        //RestTemplate支持多种方式的远程调用
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息-这里不用再写IP，直接写服务名称即可
        /*User user = template.getForObject("http://userservice/user/" + uid, User.class);*/

        // 通过Feign风格进行服务调用
        User user = userClient.findUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                /*通过Feign风格进行服务调用*/
                .map(b -> bookClient.findBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }

    @Override
    public Borrow getBorrowToUidBid(int uid, int bid) {
        Borrow borrowToUidBid = mapper.getBorrowToUidBid(uid, bid);
        return borrowToUidBid;
    }
}
