package com.mjlf.design.vistor;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/26 14:33
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        Success success = new Success();
        Faile faile = new Faile();

        ManUser manUser = new ManUser();
        WoManUser woManUser = new WoManUser();

        Count count = new Count();
        count.addUser(manUser);
        count.addUser(woManUser);

        manUser.setAction(success);
        woManUser.setAction(faile);
    }
}
