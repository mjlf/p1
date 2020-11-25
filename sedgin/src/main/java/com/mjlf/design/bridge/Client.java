package com.mjlf.design.bridge;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/25 12:03
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Style style = new LStyle();
        Phone phone = new TPhone(style);
        phone.call();

        System.out.println("    ");
        Phone phone1 = new JPhone(style);
        phone1.call();
    }
}
