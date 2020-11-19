package com.mjlf.ribbon.test.flow;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @ClassName testFlow
 * @Author mjlft
 * @Date 2020/9/16 15:40
 * @Version 1.0
 * @Description TODO
 */
public class testFlow {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher();

        publisher.subscribe(new Flow.Subscriber<Integer>() {
            Flow.Subscription subscription;
            @Override
                public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("拿到请求发布数据：" + item);
                this.subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("完成");
            }
        });

        publisher.submit(1);
        publisher.submit(2);
        publisher.submit(3);

        publisher.close();

        Thread.currentThread().join();
    }
}
