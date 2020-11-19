package com.mjlf.rxjava.compoment;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName SwitchTest
 * @Author mjlft
 * @Date 2020/10/28 17:31
 * @Version 1.0
 * @Description TODO
 */
public class SwitchTest {
    public static void main(String[] args) {
        Observable.just(1).startWith(2).subscribe(new Subscriber<Integer>() {
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
