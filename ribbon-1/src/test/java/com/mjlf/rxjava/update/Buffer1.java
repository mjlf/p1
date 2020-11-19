package com.mjlf.rxjava.update;

import rx.Observable;
import rx.Subscriber;

import java.util.List;

/**
 * @ClassName Buffer1
 * @Author mjlft
 * @Date 2020/10/23 20:22
 * @Version 1.0
 * @Description TODO
 */
public class Buffer1 {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).buffer(2).subscribe(new Subscriber<List<Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Integer> integers) {
                System.out.println(integers);
            }
        });
    }
}
