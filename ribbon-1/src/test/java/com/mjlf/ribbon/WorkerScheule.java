package com.mjlf.ribbon;

import rx.*;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.SyncOnSubscribe;
import rx.schedulers.Schedulers;

/**
 * @ClassName WorkerScheule
 * @Author mjlft
 * @Date 2020/10/23 15:20
 * @Version 1.0
 * @Description TODO
 */
public class WorkerScheule {
    public static void main(String[] args) {
        Scheduler.Worker worker = Schedulers.newThread().createWorker();

        worker.schedule(new Action0() {
            @Override
            public void call() {
                System.out.println("bcd");
            }
        });


        worker.unsubscribe();

        Single single = Single.create(new Single.OnSubscribe<String>() {
            @Override
            public void call(SingleSubscriber<? super String> singleSubscriber) {
                singleSubscriber.add(new Subscription() {
                    @Override
                    public void unsubscribe() {
                        System.out.println("unSubscrbie");
                    }

                    @Override
                    public boolean isUnsubscribed() {
                        return false;
                    }
                });
                System.out.println("成功");
            }
        });

//        single.subscribe(new Action1() {
//            @Override
//            public void call(Object o) {
//                System.out.println("call");
//            }
//        });

        single.subscribe(new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("错误");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("拿到数据" + o);
            }
        });

        single.unsubscribeOn(Schedulers.io());
    }
}
