package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName ElementAtTest
 * @Author mjlft
 * @Date 2020/10/27 22:00
 * @Version 1.0
 * @Description TODO
 */
public class ElementAtTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).elementAtOrDefault(5, 5).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });
    }
}
