package com.mjlf.design.factory.method;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName ChinaBJPizza
 * @Author mjlft
 * @Date 2020/11/19 17:11
 * @Version 1.0
 * @Description TODO
 */
public class AMBJPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("美国北京披萨材料准备");
    }

    @Override
    public void cookie() {
        System.out.println("美国北京披萨烹饪");
    }

    @Override
    public void cut() {
        System.out.println("美国北京披萨切割");
    }

    @Override
    public void box() {
        System.out.println("美国北京披萨打包");
    }
}
