package com.mjlf.design.observer;

/**
 * @ClassName Observer
 * @Author mjlft
 * @Date 2020/11/26 17:26
 * @Version 1.0
 * @Description TODO
 */
public class DogObserver implements Observer {

    @Override
    public void update(Data data){
        System.out.println("dog update");
    }
}
