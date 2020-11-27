package com.mjlf.design.strage;

/**
 * @ClassName HahaDuck
 * @Author mjlft
 * @Date 2020/11/27 14:00
 * @Version 1.0
 * @Description TODO
 */
public class HahaDuck extends Duck {

    public HahaDuck() {
        this.eat = new CanEat();
        this.fly = new CanFly();
    }
}
