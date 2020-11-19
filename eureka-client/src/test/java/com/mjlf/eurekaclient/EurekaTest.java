package com.mjlf.eurekaclient;

import com.netflix.appinfo.*;
import com.netflix.appinfo.providers.EurekaConfigBasedInstanceInfoProvider;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EurekaTest
 * @Author mjlft
 * @Date 2020/10/9 20:30
 * @Version 1.0
 * @Description TODO
 */
public class EurekaTest {

    @Test
    public void testClient(){
        EurekaInstanceConfig eurekaInstanceConfig = new MyDataCenterInstanceConfig("");
        EurekaClientConfigBean clientConfig = new EurekaClientConfigBean();
        Map<String, String> map = new HashMap<>();
        map.put("defaultZone", "http://132.232.91.106:8762/eureka");
        clientConfig.setServiceUrl(map);
        InstanceInfo instanceInfo = new EurekaConfigBasedInstanceInfoProvider(eurekaInstanceConfig).get();
        ApplicationInfoManager applicationInfoManager = new ApplicationInfoManager(eurekaInstanceConfig, instanceInfo);
        DiscoveryClient eurekaClient = new DiscoveryClient(applicationInfoManager, clientConfig);

        System.out.println(eurekaClient.getApplication("ACP").getInstances());

    }
}
