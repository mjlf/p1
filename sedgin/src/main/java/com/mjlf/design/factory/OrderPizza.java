package com.mjlf.design.factory;

import com.mjlf.design.factory.AMPizza;
import com.mjlf.design.factory.ChinaPizza;
import com.mjlf.design.factory.Pizza;

/**
 * @ClassName OrderPizza
 * @Author mjlft
 * @Date 2020/11/19 16:00
 * @Version 1.0
 * @Description TODO
 */
public class OrderPizza {

    Pizza pizza = null;

    public void order(String type){
        if("china".equals(type)){
            pizza = new ChinaPizza();
        }else if("AM".equals(type)){
            pizza = new AMPizza();
        }
        if(pizza != null){
            pizza.invoke();
        }
    }
}
