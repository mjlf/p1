package com.mjlf.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Author mjlft
 * @Date 2020/11/26 17:26
 * @Version 1.0
 * @Description TODO
 */
public class Subject {

    List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void noNotify(Data data){
        for(Observer observer: observers){
            observer.update(data);
        }
    }
}
