package com.mjlf.design.factory.method.absmethod;

import com.mjlf.design.factory.Pizza;
import com.mjlf.design.factory.method.AbsFactory;

/**
 * @ClassName Order
 * @Author mjlft
 * @Date 2020/11/19 17:33
 * @Version 1.0
 * @Description TODO
 */
public class Order {

    private AbsFactory absFactory;

    public void setAbsFactory(AbsFactory absFactory) {
        this.absFactory = absFactory;
    }

    public Pizza order(String type){
        return absFactory.createPizza(type);
    }
}
