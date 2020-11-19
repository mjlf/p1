package com.mjlf.rxjava.filter;

import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName DebounceTest
 * @Author mjlft
 * @Date 2020/10/27 21:52
 * @Version 1.0
 * @Description TODO
 */
public class DebounceTest {

    public static void main(String[] args) {
        Observable.just(1,2,3,4,5).delay(2, TimeUnit.SECONDS).debounce(900, TimeUnit.MICROSECONDS).subscribe(new Subscriber<Integer>() {
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
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
