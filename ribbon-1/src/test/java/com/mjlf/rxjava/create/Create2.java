package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.observables.SyncOnSubscribe;

/**
 * @ClassName Create2
 * @Author mjlft
 * @Date 2020/10/23 16:21
 * @Version 1.0
 * @Description TODO
 */
public class Create2 {
    public static void main(String[] args) {
        Observable.create(SyncOnSubscribe.createStateless(new Action1<Observer<? super Integer>>() {
            @Override
            public void call(Observer<? super Integer> observer) {
                observer.onNext(1);
                observer.onCompleted();
            }
        })).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("数据反射完成");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                System.out.println("异常情况");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("拿到结果" + integer);
            }
        });
        try {
            Thread.currentThread().join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
