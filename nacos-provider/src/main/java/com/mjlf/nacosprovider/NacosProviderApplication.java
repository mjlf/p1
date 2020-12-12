package com.mjlf.nacosprovider;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.swing.*;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

    public static void main(String[] args) {
//        SpringApplicationBuilder builder = new SpringApplicationBuilder().lazyInitialization(true).main(NacosProviderApplication.class);
//        builder = builder.logStartupInfo(false);
//        builder = builder.bannerMode(Banner.Mode.OFF);
//        builder.run(args);
        SpringApplication.run(NacosProviderApplication.class, args);
    }

}
