package com.mjlf.design.factory.method;

/**
 * @ClassName Store
 * @Author mjlft
 * @Date 2020/11/19 17:19
 * @Version 1.0
 * @Description TODO
 */
public class Store {
    public static void main(String[] args) {

        BJOrder bjOrder = new BJOrder();
        bjOrder.order("china");

        ShanghaiOrder shangHaiFactory = new ShanghaiOrder();
        shangHaiFactory.order("china");
    }
}
