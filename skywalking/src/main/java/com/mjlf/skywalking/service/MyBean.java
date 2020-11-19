package com.mjlf.skywalking.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyBean
 * @Author mjlft
 * @Date 2020/8/10 9:53
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyBean implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
