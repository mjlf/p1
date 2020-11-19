package com.mjlf.design.factory;

/**
 * @ClassName ChinaPizza
 * @Author mjlft
 * @Date 2020/11/19 15:58
 * @Version 1.0
 * @Description 中国披萨
 */
public class ChinaPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("制作中国披萨");
    }

    @Override
    public void cookie() {
        System.out.println("烹饪中国披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割中国披萨");
    }

    @Override
    public void box() {
        System.out.println("打包中国披萨");
    }
}
