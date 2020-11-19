package com.mjlf;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName com.mjlf.Main
 * @Author mjlft
 * @Date 2020/5/25 21:26
 * @Version 1.0
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("start");
        test();
    }

    public static void test() throws Exception{
        System.out.println("nnn");
        TimeUnit.SECONDS.sleep(1);
    }
}
