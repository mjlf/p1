package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName TakeTest
 * @Author mjlft
 * @Date 2020/10/27 22:48
 * @Version 1.0
 * @Description TODO
 */
public class TakeTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4).take(2).subscribe(new Subscriber<Integer>() {
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
