package com.mjlf.design.factory.method;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName AbsFactory
 * @Author mjlft
 * @Date 2020/11/19 17:11
 * @Version 1.0
 * @Description 北京披萨工厂
 */
public class ShangHaiFactory extends AbsFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;
        if("china".equals(type)){
            pizza = new ChinaShanghaiPizza();
        }else if("AM".equals(type)){
            pizza = new AMShanghaiPizza();
        }
        if(pizza != null){
            pizza.invoke();
        }
        return pizza;
    }
}
