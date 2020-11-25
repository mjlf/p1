package com.mjlf.design.decorator;

/**
 * @ClassName CoffeMilk
 * @Author mjlft
 * @Date 2020/11/25 13:23
 * @Version 1.0
 * @Description TODO
 */
public class MMilk extends Milk {
    private Milk milk;

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public int getPrice(){
        return 3 + this.milk.getPrice();
    }
}
