package com.mjlf.skywalking;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.mjlf.skywalking.entity.AcmProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
//@EnableConfigurationProperties(AcmProperties.class)
public class SkywalkingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkingApplication.class, args);
    }

    @Autowired
    private AcmProperties acmProperties;

    @Bean
    public Integer getArgs(ApplicationArguments args){
        System.out.println(acmProperties);
        args.getOptionNames().forEach(System.out::println);
        return 1;
    }
}
