package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName LastTest
 * @Author mjlft
 * @Date 2020/10/27 22:32
 * @Version 1.0
 * @Description TODO
 */
public class LastTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).last().subscribe(new Subscriber<Integer>() {
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
