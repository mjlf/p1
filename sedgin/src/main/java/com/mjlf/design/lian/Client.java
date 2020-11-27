package com.mjlf.design.lian;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/27 14:54
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        None none = new None(null);
        TwoFilter twoFilter = new TwoFilter(none);
        OneFilter oneFilter = new OneFilter(twoFilter);

        oneFilter.doFileter();
    }
}
