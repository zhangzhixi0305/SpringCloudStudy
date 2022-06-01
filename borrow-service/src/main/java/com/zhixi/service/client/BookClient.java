package com.zhixi.service.client;

import com.zhixi.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName BookClient
 * @Author zhangzhixi
 * @Description 实现在Controller中更便捷的服务调用
 * @Date 2022-6-1 8:46
 * @Version 1.0
 */
@FeignClient("bookerservice")
public interface BookClient {

    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid);
}
