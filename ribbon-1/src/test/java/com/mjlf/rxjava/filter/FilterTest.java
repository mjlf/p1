package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName FilterTest
 * @Author mjlft
 * @Date 2020/10/27 22:02
 * @Version 1.0
 * @Description TODO
 */
public class FilterTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8).filter( x -> x % 2 == 0).subscribe(new Subscriber<Integer>() {
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
