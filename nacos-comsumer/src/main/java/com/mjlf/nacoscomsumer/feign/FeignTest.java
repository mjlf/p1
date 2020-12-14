package com.mjlf.nacoscomsumer.feign;

import com.mjlf.nacoscomsumer.service.FallbackService;
import feign.Feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName FeignTest
 * @Author mjlft
 * @Date 2020/12/12 16:40
 * @Version 1.0
 * @Description TODO
 */
@FeignClient(value = "provider", fallback = FallbackService.class)
public interface FeignTest {

    @GetMapping("/config/get")
    String getConfig();
}
