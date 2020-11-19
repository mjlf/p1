package com.mjlf.design.factory;

/**
 * @ClassName ChinaPizza
 * @Author mjlft
 * @Date 2020/11/19 15:58
 * @Version 1.0
 * @Description 美国披萨
 */
public class AMPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("制作美国披萨");
    }

    @Override
    public void cookie() {
        System.out.println("烹饪美国披萨");
    }

    @Override
    public void cut() {
        System.out.println("切割美国披萨");
    }

    @Override
    public void box() {
        System.out.println("打包美国披萨");
    }
}
