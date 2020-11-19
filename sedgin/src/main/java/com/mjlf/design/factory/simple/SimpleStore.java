package com.mjlf.design.factory.simple;

import com.mjlf.design.factory.OrderPizza;

/**
 * @ClassName SimpleStore
 * @Author mjlft
 * @Date 2020/11/19 16:31
 * @Version 1.0
 * @Description TODO
 */
public class SimpleStore {
    public static void main(String[] args) {
        SimlpeOrder simlpeOrder = new SimlpeOrder();
        simlpeOrder.order("china");
    }
}
