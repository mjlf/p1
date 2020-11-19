package com.mjlf.interceptor;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @ClassName MyInterceptor
 * @Author mjlft
 * @Date 2020/5/26 9:10
 * @Version 1.0
 * @Description TODO
 */
public class MyInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception{
        long startTime = System.currentTimeMillis();
        try{
            return callable.call();
        }finally {
            System.out.println(method.getName() + ":" + (System.currentTimeMillis() - startTime));
        }
    }
}
