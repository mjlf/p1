package com.mjlf.rxjava.compoment;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * @ClassName AndThenWhen
 * @Author mjlft
 * @Date 2020/10/28 15:05
 * @Version 1.0
 * @Description TODO
 */
public class AndThenWhen {

    public static void main(String[] args) {
        Observable.combineLatest(Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for(int i = 1; i < 3; i ++){
                    subscriber.onNext(i);
                    subscriber.onCompleted();
                }
            }
        }), Observable.just(1, 3, 7), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(new Subscriber<Integer>() {
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
