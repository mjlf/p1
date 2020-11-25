package com.mjlf.design.bridge;

/**
 * @ClassName Phone
 * @Author mjlft
 * @Date 2020/11/25 11:55
 * @Version 1.0
 * @Description TODO
 */
public abstract class Phone {

    public Style style;

    public Phone(Style style) {
        this.style = style;
    }

    public void call(){
        start();
        this.style.call();
        this.style.shutdown();
    }

    public abstract void start();
}
