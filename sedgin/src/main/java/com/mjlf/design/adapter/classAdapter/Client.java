package com.mjlf.design.adapter.classAdapter;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/23 10:03
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Adapter adapter = new Adapter();

        phone.setAdapter(adapter);
        phone.cd();
    }
}
