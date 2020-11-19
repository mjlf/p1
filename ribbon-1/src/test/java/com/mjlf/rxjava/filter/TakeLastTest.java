package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName TakeLastTest
 * @Author mjlft
 * @Date 2020/10/27 22:52
 * @Version 1.0
 * @Description TODO
 */
public class TakeLastTest {

    public static void main(String[] args) {
        Observable.just(1, 3, 4, 5).takeLast(2).subscribe(new Subscriber<Integer>() {
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
