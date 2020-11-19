package com.mjlf.ribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MidController
 * @Author mjlft
 * @Date 2020/9/17 22:20
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String HELLO_SERVICE = "HTTP://MID";

    @GetMapping("/bcd")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hello() {
        // return restTemplate.getForObject(HELLO_SERVICE + "hello", String.class);
        return restTemplate.getForEntity(HELLO_SERVICE + "/test/abc", String.class).getBody();
    }

    public String fallback(){
        return "fallback";
    }
}
