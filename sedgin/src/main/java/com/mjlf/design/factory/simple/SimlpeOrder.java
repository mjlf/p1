package com.mjlf.design.factory.simple;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName SimlpeOrder
 * @Author mjlft
 * @Date 2020/11/19 16:30
 * @Version 1.0
 * @Description TODO
 */
public class SimlpeOrder {
    public void order(String type){
        Pizza pizza = SimpleFactory.createPizza(type);
    }
}
