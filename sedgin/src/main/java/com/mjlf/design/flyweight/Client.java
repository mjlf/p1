package com.mjlf.design.flyweight;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/25 18:08
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        AFactory aFactory = new AFactory();

        WebSite webSite = aFactory.getWebSite("a");
        webSite.use();

        WebSite webSite1 = aFactory.getWebSite("b");
        webSite1.use();

        WebSite webSite2 = aFactory.getWebSite("b");
        webSite2.use();

        aFactory.showNum();
    }
}
