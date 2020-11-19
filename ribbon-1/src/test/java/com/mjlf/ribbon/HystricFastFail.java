package com.mjlf.ribbon;

import com.netflix.hystrix.*;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.eventnotifier.HystrixEventNotifier;
import com.netflix.hystrix.strategy.executionhook.HystrixCommandExecutionHook;
import com.netflix.hystrix.strategy.properties.HystrixPropertiesStrategy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HystricFastFail
 * @Author mjlft
 * @Date 2020/10/20 21:06
 * @Version 1.0
 * @Description TODO
 */
public class HystricFastFail extends HystrixCommand {

    private boolean fastFail;

    public HystricFastFail(Boolean b) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ThreadPoolTestGroup"))
                        .andCommandKey(HystrixCommandKey.Factory.asKey("testCommandKey"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(""))
                        .andCommandPropertiesDefaults(
                                HystrixCommandProperties.Setter()
                                        .withCircuitBreakerEnabled(true)//默认是true，本例中为了展现该参数
                                        .withCircuitBreakerForceOpen(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerForceClosed(false)//默认是false，本例中为了展现该参数
                                        .withCircuitBreakerErrorThresholdPercentage(5)//(1)错误百分比超过5%
                                        .withCircuitBreakerRequestVolumeThreshold(10)//(2)10s以内调用次数10次，同时满足(1)(2)熔断器打开
                                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//隔5s之后，熔断器会尝试半开(关闭)，重新放进来请求
//
                                        .withRequestCacheEnabled(false)
//                                .withExecutionTimeoutInMilliseconds(1000)
                        )
                        .andThreadPoolPropertiesDefaults(
                                HystrixThreadPoolProperties.Setter()
                                        .withMaxQueueSize(10)   //配置队列大小
                                        .withCoreSize(2)    // 配置线程池里的线程数
                        )
        );
        this.fastFail = b;
    }

    @Override
    protected Object run() throws Exception {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new Exception("fast faile");
        }
        return "null";
    }

    @Override
    protected Object getFallback() {
        return "fast faile";
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(fastFail);
    }

    public static void main(String[] args) throws InterruptedException {
        
//       try(HystrixRequestContext context = HystrixRequestContext.initializeContext()) {
           for (int i = 0; i < 40; i++) {
               Thread.sleep(500);
               HystricFastFail hystricFastFail = new HystricFastFail(false);
               System.out.println(hystricFastFail.execute());
               System.out.println(hystricFastFail.isCircuitBreakerOpen());
//           }
       }
    }
}
