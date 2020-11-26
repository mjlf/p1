package com.mjlf.design.memento;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/26 19:45
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Memento memento = new Memento();
        Obj obj = new Obj("hhh");
        obj.setMemento(memento);


        obj.saveState();
        obj.setState("bbb");
        System.out.println(obj);
        obj.getStateFromMemento();
        System.out.println(obj);
    }
}
