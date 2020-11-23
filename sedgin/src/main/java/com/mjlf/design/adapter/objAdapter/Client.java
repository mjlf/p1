package com.mjlf.design.adapter.objAdapter;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/23 10:03
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Vlatger220 vlatger220 = new Vlatger220();
        Adapter adapter = new Adapter(vlatger220);

        Phone phone = new Phone();
        phone.setAdapter(adapter);

        phone.cd();
    }
}
