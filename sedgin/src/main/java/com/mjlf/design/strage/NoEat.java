package com.mjlf.design.strage;

/**
 * @ClassName NoEat
 * @Author mjlft
 * @Date 2020/11/27 13:58
 * @Version 1.0
 * @Description TODO
 */
public class NoEat implements Eat {

    @Override
    public void cat() {
        System.out.println("不能吃");
    }
}
