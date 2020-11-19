package com.mjlf.rxjava.rx1;

import io.reactivex.rxjava3.core.Flowable;

/**
 * @ClassName FlowAbleTest
 * @Author mjlft
 * @Date 2020/10/21 10:11
 * @Version 1.0
 * @Description TODO
 */
public class FlowAbleTest {
    public static void main(String[] args) {
        Flowable.fromArray(1, 2, 4).subscribe(System.out::println);
    }
}
