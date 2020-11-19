package com.mjlf.ribbon.test.fallback;

import com.netflix.hystrix.HystrixInvokableInfo;
import com.netflix.ribbon.hystrix.FallbackHandler;

import java.util.Map;

/**
 * @ClassName RecommendationServiceFallbackHandler
 * @Author mjlft
 * @Date 2020/9/15 20:04
 * @Version 1.0
 * @Description TODO
 */
public class RecommendationServiceFallbackHandler implements FallbackHandler {
    @Override
    public rx.Observable getFallback(HystrixInvokableInfo hystrixInvokableInfo, Map map) {
        System.out.println("getFallback");
        return null;
    }
}
