package com.mjlf.design.factory.method;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName ChinaBJPizza
 * @Author mjlft
 * @Date 2020/11/19 17:11
 * @Version 1.0
 * @Description TODO
 */
public class AMShanghaiPizza implements Pizza {

    @Override
    public void prepare() {
        System.out.println("美国上海披萨材料准备");
    }

    @Override
    public void cookie() {
        System.out.println("美国上海披萨烹饪");
    }

    @Override
    public void cut() {
        System.out.println("美国上海披萨切割");
    }

    @Override
    public void box() {
        System.out.println("美国上海披萨打包");
    }
}
