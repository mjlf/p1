package com.mjlf.ribbon.mid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName MidController
 * @Author mjlft
 * @Date 2020/9/17 22:20
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/test")
public class MidController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String B = "HTTP://B";
    private static final String C = "HTTP://C";
    private static final String D = "HTTP://D";

    @GetMapping("/a")
    public String a(HttpServletRequest request) {
        showHeader(request);
        return restTemplate.getForEntity(B + "/test/b", String.class).getBody();
    }

    @GetMapping("/b")
    public String b(HttpServletRequest request) {
        showHeader(request);
        return restTemplate.getForEntity(C + "/test/c", String.class).getBody();
    }

    @GetMapping("/c")
    public String c(HttpServletRequest request) {
        showHeader(request);
        return restTemplate.getForEntity(B + "/test/d", String.class).getBody();
    }

    @GetMapping("/d")
    public String d(HttpServletRequest request) {
        showHeader(request);
        return restTemplate.getForEntity(D + "/test/e", String.class).getBody();
    }

    @GetMapping("/e")
    public String e(HttpServletRequest request) {
        showHeader(request);
        return "yes";
    }

    public void showHeader(HttpServletRequest request){
        Enumeration<String> enumeration =  request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String headerName = enumeration.nextElement();
            System.out.println(headerName + " ------- " + request.getHeader(headerName));
        }
    }
}
