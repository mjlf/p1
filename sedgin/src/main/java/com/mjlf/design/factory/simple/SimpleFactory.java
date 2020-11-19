package com.mjlf.design.factory.simple;

import com.mjlf.design.factory.AMPizza;
import com.mjlf.design.factory.ChinaPizza;
import com.mjlf.design.factory.Pizza;

/**
 * @ClassName SimpleFactory
 * @Author mjlft
 * @Date 2020/11/19 16:28
 * @Version 1.0
 * @Description TODO
 */
public class SimpleFactory {
    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if("china".equals(type)){
            pizza = new ChinaPizza();
        }else if("AM".equals(type)){
            pizza = new AMPizza();
        }
        if(pizza != null){
            pizza.invoke();
        }
        return pizza;
    }
}
