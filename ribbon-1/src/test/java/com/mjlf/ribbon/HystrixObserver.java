package com.mjlf.ribbon;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import com.netflix.hystrix.contrib.javanica.command.HystrixCommandFactory;
import rx.Observable;

import java.util.concurrent.ExecutionException;

/**
 * @ClassName HystrixObserver
 * @Author mjlft
 * @Date 2020/10/20 21:14
 * @Version 1.0
 * @Description TODO
 */
public class HystrixObserver extends HystrixObservableCommand<String> {
    private boolean fastFail;

    public HystrixObserver(HystrixCommandGroupKey group, boolean f) {
        super(group);
        this.fastFail = f;
    }

    @Override
    protected Observable<String> construct() {
        if (fastFail) {
           return Observable.error(new RuntimeException("fast fail"));
        }
        return Observable.just("success");
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        return Observable.just("fast fail");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(new HystrixObserver(HystrixCommandGroupKey.Factory.asKey("hab"), true).toObservable().toBlocking().toFuture().get());
    }
}
