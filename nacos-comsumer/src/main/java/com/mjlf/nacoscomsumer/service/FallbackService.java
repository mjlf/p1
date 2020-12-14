package com.mjlf.nacoscomsumer.service;

import com.mjlf.nacoscomsumer.feign.FeignTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName FallbackService
 * @Author mjlft
 * @Date 2020/12/14 19:46
 * @Version 1.0
 * @Description TODO
 */
@Component
public class FallbackService implements FeignTest {

    public String getConfig() {
        return "降级处理";
    }
}
