package com.mjlf.design.factory;

/**
 * @ClassName ChinaStore
 * @Author mjlft
 * @Date 2020/11/19 16:04
 * @Version 1.0
 * @Description 中国商店
 */
public class ChinaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza();
        orderPizza.order("AM");
    }
}
