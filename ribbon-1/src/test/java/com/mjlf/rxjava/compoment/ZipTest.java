package com.mjlf.rxjava.compoment;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.schedulers.NewThreadWorker;
import rx.schedulers.Timestamped;

/**
 * @ClassName ZipTest
 * @Author mjlft
 * @Date 2020/10/28 20:12
 * @Version 1.0
 * @Description TODO
 */
public class ZipTest {
    public static void main(String[] args) {
        Observable.zip(Observable.just(1, 2, 3), Observable.just(2, 3, 3), new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).timestamp().subscribe(new Subscriber<Timestamped>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Timestamped integer) {
                System.out.println(integer);
            }
        });
    }
}
