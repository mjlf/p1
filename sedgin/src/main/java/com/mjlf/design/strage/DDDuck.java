package com.mjlf.design.strage;

/**
 * @ClassName HahaDuck
 * @Author mjlft
 * @Date 2020/11/27 14:00
 * @Version 1.0
 * @Description TODO
 */
public class DDDuck extends Duck {

    public DDDuck() {
        this.eat = new NoEat();
        this.fly = new NoFly();
    }
}
