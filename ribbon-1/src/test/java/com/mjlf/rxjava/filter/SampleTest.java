package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SampleTest
 * @Author mjlft
 * @Date 2020/10/27 22:34
 * @Version 1.0
 * @Description TODO
 */
public class SampleTest {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5).sample(1, TimeUnit.NANOSECONDS).subscribe(new Subscriber<Integer>() {
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
