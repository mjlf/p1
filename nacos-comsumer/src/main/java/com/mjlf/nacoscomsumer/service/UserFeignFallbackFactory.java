package com.mjlf.nacoscomsumer.service;

import com.mjlf.nacoscomsumer.feign.FeignTest;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallbackFactory implements FallbackFactory<FeignTest> {
	@Override
	public FeignTest create(Throwable cause) {
		FallbackService feign = new FallbackService();
		return null;
	}
}
