package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName Range
 * @Author mjlft
 * @Date 2020/10/23 19:59
 * @Version 1.0
 * @Description TODO
 */
public class Range {
    public static
    void main(String[] args) {
        Observable.range(1, 10).subscribe(new Subscriber<Integer>() {
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
