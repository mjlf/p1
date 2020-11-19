package com.mjlf.ribbon.test.fallback;

import com.netflix.ribbon.ResponseValidator;
import com.netflix.ribbon.ServerError;
import com.netflix.ribbon.UnsuccessfulResponseException;

/**
 * @ClassName RecommendationServiceResponseValidator
 * @Author mjlft
 * @Date 2020/9/15 20:06
 * @Version 1.0
 * @Description TODO
 */
public class RecommendationServiceResponseValidator implements ResponseValidator {
    @Override
    public void validate(Object o) throws UnsuccessfulResponseException, ServerError {
        System.out.println("validate");
    }
}
