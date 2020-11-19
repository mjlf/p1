package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName Just
 * @Author mjlft
 * @Date 2020/10/23 19:55
 * @Version 1.0
 * @Description TODO
 */
public class Just {
    public static void main(String[] args) {
        Observable.just(1, 2, 3).subscribe(new Subscriber<Integer>() {
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
