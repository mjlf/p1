package com.mjlf.rxjava.rx1;

import io.reactivex.rxjava3.core.Observable;

/**
 * @ClassName ObserverCreateTest
 * @Author mjlft
 * @Date 2020/10/21 10:14
 * @Version 1.0
 * @Description TODO
 */
public class ObserverCreateTest {
    public static Observable create(){
        return Observable.create( ob -> {
            ob.onNext("abc");
        });
    }

    public static void main(String[] args) {
        ObserverCreateTest.create().subscribe(System.out::println);
    }
}
