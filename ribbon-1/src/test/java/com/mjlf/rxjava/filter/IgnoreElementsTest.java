package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName IgnoreElementsTest
 * @Author mjlft
 * @Date 2020/10/27 22:14
 * @Version 1.0
 * @Description TODO
 */
public class IgnoreElementsTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).ignoreElements().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
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
