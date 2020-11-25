package com.mjlf.design.decorator;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/25 13:25
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        Milk milk = new Milk();

        CoffeMilk coffeMilk = new CoffeMilk();
        coffeMilk.setMilk(milk);
        coffeMilk.showPrice();

        MMilk mMilk = new MMilk();
        mMilk.setMilk(coffeMilk);
        mMilk.showPrice();
    }
}
