package com.mjlf.design.decorator;

/**
 * @ClassName Milk
 * @Author mjlft
 * @Date 2020/11/25 13:22
 * @Version 1.0
 * @Description TODO
 */
public class Milk {
    public int getPrice(){
        return 10;
    }

    public void showPrice(){
        System.out.println(getPrice());
    }
}
