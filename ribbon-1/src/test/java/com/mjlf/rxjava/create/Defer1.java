package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.observables.SyncOnSubscribe;

/**
 * @ClassName Defer1
 * @Author mjlft
 * @Date 2020/10/23 16:55
 * @Version 1.0
 * @Description TODO
 */
public class Defer1 {
    public static void main(String[] args) {
        Observable.defer(()->{
            return Observable.create(new Observable.OnSubscribe<Integer>() {
                @Override
                public void call(Subscriber<? super Integer> subscriber) {
                    if(!subscriber.isUnsubscribed()){
                        for (int i = 0; i < 10; i ++){
                            subscriber.onNext(i);
                        }
                    }
                    subscriber.onCompleted();
                }
            });
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("拿到数据" + integer);
            }
        });
    }
}
