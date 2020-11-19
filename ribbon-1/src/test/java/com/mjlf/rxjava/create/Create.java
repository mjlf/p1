package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Subscriber;
import rx.observables.SyncOnSubscribe;

/**
 * @ClassName Create
 * @Author mjlft
 * @Date 2020/10/23 16:09
 * @Version 1.0
 * @Description TODO
 */
public class Create {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        for (int i = 0; i < 10; i++) {
                            subscriber.onNext(i);
                        }
                        subscriber.onCompleted();
                    }
                } catch (Exception e) {
                    //错误处理
                    subscriber.onError(e);
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("数据反射完成");
            }

            @Override
            public void onError(Throwable e) {
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
