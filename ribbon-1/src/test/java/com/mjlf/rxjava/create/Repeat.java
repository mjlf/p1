package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName Repeat
 * @Author mjlft
 * @Date 2020/10/23 20:02
 * @Version 1.0
 * @Description TODO
 */
public class Repeat {

    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(2);
                subscriber.onCompleted();
            }
        }).repeat(3).subscribe(new Subscriber<Integer>() {
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
