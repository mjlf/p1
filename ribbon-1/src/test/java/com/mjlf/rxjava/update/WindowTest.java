package com.mjlf.rxjava.update;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName WindowTest
 * @Author mjlft
 * @Date 2020/10/27 21:43
 * @Version 1.0
 * @Description TODO
 */
public class WindowTest {
    public static void main(String[] args) {
        Observable.just(2, 4, 6, 8).window(2).subscribe(new Subscriber<Observable<Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                integerObservable.subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("完成");
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
        });
    }
}
