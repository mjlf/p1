package com.mjlf.apollo.poart;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.core.MetaDomainConsts;
import com.ctrip.framework.apollo.internals.RemoteConfigLongPollService;
import com.ctrip.framework.apollo.internals.RemoteConfigRepository;
import com.ctrip.framework.apollo.internals.SimpleConfig;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import com.ctrip.framework.apollo.openapi.dto.OpenNamespaceDTO;
import com.ctrip.framework.foundation.internals.provider.DefaultApplicationProvider;
import org.junit.Test;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/10/9 20:11
 * @Version 1.0
 * @Description TODO
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
        String portalUrl = "http://132.232.86.100:8070"; // portal url
        String token = "076624fa07a2495807568287b6a421818dceb009"; // 申请的token
        ApolloOpenApiClient client = ApolloOpenApiClient.newBuilder()
                .withPortalUrl(portalUrl)
                .withToken(token)
                .build();
        try {
            OpenNamespaceDTO openNamespaceDTO = client.getNamespace("ACP", "dev", null, "proatocol");
            System.out.println(openNamespaceDTO.getAppId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("开始时间" + System.currentTimeMillis());
        long startTime = System.currentTimeMillis();


        Config config = ConfigService.getConfig("ACP.protocol");
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent configChangeEvent) {
                System.out.println("xxxx");
            }
        });
        System.out.println("结束时间" + System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - startTime);
        Thread.currentThread().join(100000000);
        //添加namespace
//        OpenAppNamespaceDTO appNamespaceDTO = new OpenAppNamespaceDTO();
//        appNamespaceDTO.setAppId("ACP");
//        appNamespaceDTO.setName("test");
//        appNamespaceDTO.setDataChangeCreatedBy("apollo");
//        appNamespaceDTO.setDataChangeCreatedTime(new Date());
//        appNamespaceDTO.setDataChangeLastModifiedBy("apollo");
//        appNamespaceDTO.setDataChangeLastModifiedTime(new Date());
//        appNamespaceDTO.setPublic(false);
//
//        client.createAppNamespace(appNamespaceDTO);
    }


    @Test
    public void testHackConfig() {
        String someNamespace = "application";
        String someKey = "id";
        long start = System.currentTimeMillis();
        System.setProperty("apollo.meta", "http://106.54.227.205:8080");
        System.setProperty("app.id", "first_apollo_for_gz");
        Config config = ConfigService.getConfig("application");
        System.out.println("开始时间" + (System.currentTimeMillis() - start));
    }
}
