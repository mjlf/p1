package com.mjlf.design.factory.method.absmethod;

import com.mjlf.design.factory.method.BJFactory;
import com.mjlf.design.factory.method.ShangHaiFactory;

import java.util.Calendar;

/**
 * @ClassName Store
 * @Author mjlft
 * @Date 2020/11/19 17:34
 * @Version 1.0
 * @Description TODO
 */
public class Store {

    public static void main(String[] args) {
        BJFactory bjFactory = new BJFactory();
        ShangHaiFactory shangHaiFactory = new ShangHaiFactory();

        Order order = new Order();
        order.setAbsFactory(bjFactory);
        order.order("china");

        order.setAbsFactory(shangHaiFactory);
        order.order("china");
    }
}
