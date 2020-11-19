package com.mjlf.ribbon.test.rx;

import rx.*;
import rx.functions.Action1;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

/**
 * @ClassName RxText
 * @Author mjlft
 * @Date 2020/9/16 17:12
 * @Version 1.0
 * @Description TODO
 */
public class RxText {
    public static void main(String[] args) throws InterruptedException {
        test(1, 2, 3);
    }

    public static void test(Integer ... nums) throws InterruptedException {


        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                System.out.println("错误");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("拿到数据" + o);
            }
        };
        Observable.OnSubscribe<Integer> onSubscribe = new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onNext(3);
                subscriber.onCompleted();
            }
        };
        Observable.unsafeCreate(onSubscribe).filter(item -> {
            return item % 2 == 0;
        }).subscribeOn(Schedulers.computation( )).map(item -> {
            return item * 2 + 1;
        }).flatMap(item -> {
            return Observable.range(0, item);
        }).observeOn(Schedulers.io()).subscribe(subscriber);

        Thread.currentThread().join();
    }
}
