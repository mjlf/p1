package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName SkipTest
 * @Author mjlft
 * @Date 2020/10/27 22:38
 * @Version 1.0
 * @Description TODO
 */
public class SkipTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 9).skip(3).subscribe(new Subscriber<Integer>() {
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
