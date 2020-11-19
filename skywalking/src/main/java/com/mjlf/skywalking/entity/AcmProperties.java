package com.mjlf.skywalking.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName AcmProperties
 * @Author mjlft
 * @Date 2020/8/10 16:19
 * @Version 1.0
 * @Description TODO
 */
//@ConstructorBinding
@Data
@Component
@ConfigurationProperties(prefix = "acm")
public class AcmProperties {
    private String one;
    private String two;
    private String three;

//    public AcmProperties(String one, String two, @DefaultValue("ree") String three) {
//        this.one = one;
//        this.two = two;
//        this.three = three;
//    }

    @Override
    public String toString() {
        return "AcmProperties{" +
                "one='" + one + '\'' +
                ", two='" + two + '\'' +
                ", three='" + three + '\'' +
                '}';
    }
}
