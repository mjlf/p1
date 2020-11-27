package com.mjlf.design.state;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/27 12:44
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        Actity actity = new Actity();
        actity.setState(new StartState(actity));

        actity.doV();
        actity.doV();
    }
}
