package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName DistinctTest
 * @Author mjlft
 * @Date 2020/10/27 21:58
 * @Version 1.0
 * @Description TODO
 */
public class DistinctTest {
    public static void main(String[] args) {
        Observable.just(1, 1, 3,3, 4).distinct().subscribe(new Subscriber<Integer>() {
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

