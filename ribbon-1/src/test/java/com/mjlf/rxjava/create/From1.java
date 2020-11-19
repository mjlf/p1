package com.mjlf.rxjava.create;

import rx.Observable;
import rx.Subscriber;

/**
 * @ClassName From1
 * @Author mjlft
 * @Date 2020/10/23 17:07
 * @Version 1.0
 * @Description TODO
 */
public class From1 {
    public static void main(String[] args) {
        Integer[] items = new Integer[]{1, 3, 4};
        Observable.from(items).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                System.out.println("错误");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("拿到数据" + integer);
            }
        });
    }
}
