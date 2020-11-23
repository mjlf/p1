package com.mjlf.design.adapter.interAdapter;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/23 12:33
 * @Version 1.0
 * @Description 通过内部类的方式使用接口适配器
 */
public class Client {

    public static void main(String[] args) {
        new Phone().create(new AbsA() {
            @Override
            public void a1() {
                System.out.println("a");
            }
        });
    }
}
