package com.mjlf.design.factory.method;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName Order
 * @Author mjlft
 * @Date 2020/11/19 17:17
 * @Version 1.0
 * @Description TODO
 */
public class Order {
    AbsFactory absFactory = null;

    public AbsFactory getAbsFactory() {
        return absFactory;
    }

    public void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
    }

    public Pizza order(String type){
        return absFactory.createPizza(type);
    }
}
