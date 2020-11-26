package com.mjlf.design.observer;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/26 17:30
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();

        DogObserver dogObserver = new DogObserver();
        CatObserver catObserver = new CatObserver();

        subject.add(dogObserver);
        subject.add(catObserver);

        subject.noNotify(new Data());

        subject.remove(catObserver);
        subject.noNotify(new Data());
    }
}
