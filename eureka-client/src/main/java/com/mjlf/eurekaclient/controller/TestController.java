package com.mjlf.eurekaclient.controller;

import com.mjlf.eurekaclient.entity.User;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClientConfig;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestController
 * @Author mjlft
 * @Date 2020/8/23 12:35
 * @Version 1.0
 * @Description TODO
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello1")
    public String hello(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @Autowired
    EurekaInstanceConfig config;

    @Autowired
    EurekaClientConfig clientConfig;

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping("/shutwown")
    public String shutdown(){
        ApplicationInfoManager manager = new ApplicationInfoManager(config);
//
//        DiscoveryClient discoveryClient = new DiscoveryClient(manager, clientConfig);
//
//        discoveryClient.shutdown();

        CloudEurekaClient cloudEurekaClient = new CloudEurekaClient(manager, clientConfig, publisher);
        cloudEurekaClient.setStatus(InstanceInfo.InstanceStatus.DOWN,
                cloudEurekaClient.getInstanceInfo(config.getAppname(), config.getInstanceId()));

        return "yes";
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody @Validated User user){
        System.out.println(user);
    }
}
