package com.mjlf.nacosprovider.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName AsyncService
 * @Author mjlft
 * @Date 2020/12/14 15:22
 * @Version 1.0
 * @Description TODO
 */
@Service
@Async
public class AsyncService {

    public String abc() throws InterruptedException {
        System.out.println("开始异步调用");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("异步调用结束");
        return "abc";
    }
}
