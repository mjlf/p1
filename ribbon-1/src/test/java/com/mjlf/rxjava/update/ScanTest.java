package com.mjlf.rxjava.update;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName ScanTest
 * @Author mjlft
 * @Date 2020/10/27 21:39
 * @Version 1.0
 * @Description TODO
 */
public class ScanTest {
    public static void main(String[] args) {
        Observable.just(1, 3, 5, 7).scan((x, y) -> x+y).subscribe(new Subscriber<Integer>() {
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
