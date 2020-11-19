package com.mjlf.ribbon.test.http;

import com.mjlf.ribbon.test.fallback.RecommendationServiceFallbackHandler;
import com.mjlf.ribbon.test.fallback.RecommendationServiceResponseValidator;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;
import io.netty.buffer.ByteBuf;
import rx.Observable;

/**
 * @ClassName HttpTest
 * @Author mjlft
 * @Date 2020/9/15 20:00
 * @Version 1.0
 * @Description ribbon http 测试， 实现负载均衡
 */
public class HttpTest {

    public static void main(String[] args) {
        HttpResourceGroup httpResourceGroup = Ribbon.createHttpResourceGroup("movieServiceClient",
                ClientOptions.create()
                        .withMaxAutoRetriesNextServer(3)
                        .withConfigurationBasedServerList("localhost:8088,localhost:8080"));

        HttpRequestTemplate<String> recommendationsByUserIdTemplate = httpResourceGroup.newTemplateBuilder("recommendationsByUserId", ByteBuf.class)
                .withMethod("GET")
                .withUriTemplate("/test/hello1")
                .withFallbackProvider(new RecommendationServiceFallbackHandler())
                .withResponseValidator(new RecommendationServiceResponseValidator())
                .build();
       RibbonRequest<String> ribbonRequest  = recommendationsByUserIdTemplate.requestBuilder()
                .withRequestProperty("userId", "user1")
                .build();

       String str = ribbonRequest.execute();
        System.out.println(str);
    }
}
