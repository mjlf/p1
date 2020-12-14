package com.mjlf.nacosprovider.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SentinelConfiguration
 * @Author mjlft
 * @Date 2020/12/14 16:05
 * @Version 1.0
 * @Description TODO
 */
@Configuration
public class SentinelConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
