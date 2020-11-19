package com.mjlf.design.factory.method;

import com.mjlf.design.factory.Pizza;

/**
 * @ClassName AbsFactory
 * @Author mjlft
 * @Date 2020/11/19 17:11
 * @Version 1.0
 * @Description TODO
 */
public abstract class AbsFactory {

    public abstract Pizza createPizza(String type);
}
