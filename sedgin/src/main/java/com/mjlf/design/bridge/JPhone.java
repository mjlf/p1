package com.mjlf.design.bridge;

/**
 * @ClassName Phone
 * @Author mjlft
 * @Date 2020/11/25 11:55
 * @Version 1.0
 * @Description TODO
 */
public class JPhone extends Phone {

    public JPhone(Style style) {
        super(style);
    }

    public void call(){
        start();
        this.style.call();
        this.style.shutdown();
    }

    public void start(){
        System.out.println("J start");
    }
}
