package com.mjlf.design.flyweight;

/**
 * @ClassName NetWebSite
 * @Author mjlft
 * @Date 2020/11/25 18:04
 * @Version 1.0
 * @Description TODO
 */
public class NetWebSite implements WebSite {

    private String type;

    public NetWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use() {
        System.out.println("哈哈哈" + type);
    }
}
