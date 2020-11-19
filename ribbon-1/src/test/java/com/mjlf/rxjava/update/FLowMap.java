package com.mjlf.rxjava.update;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @ClassName FLowMap
 * @Author mjlft
 * @Date 2020/10/23 20:27
 * @Version 1.0
 * @Description TODO
 */
public class FLowMap {
    public static void main(String[] args) {
        Observable.just("123,123,123").flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        for (String s1 : s.split(",")) {
                            subscriber.onNext(s1);
                        }
                    }
                });
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
}
