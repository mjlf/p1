package com.mjlf.ribbon;

import rx.Single;

/**
 * @ClassName RxSingle
 * @Author mjlft
 * @Date 2020/10/23 14:50
 * @Version 1.0
 * @Description TODO
 */
public class RxSingle {
    public static void main(String[] args) {
        Single.just("abc").doOnError(obj -> {
            System.out.println("error");
        }).map(obj -> {
            return obj + "dac";
        }).doOnEach(obj -> {
            System.out.println("do each ");
        }).subscribe(obj -> {

            System.out.println(obj);
        });
    }
}
