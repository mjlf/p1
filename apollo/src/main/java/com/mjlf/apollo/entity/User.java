package com.mjlf.apollo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @ClassName User
 * @Author mjlft
 * @Date 2020/5/15 9:55
 * @Version 1.0
 * @Description TODO
 */
@Data
public class User {
    @Value("${id:1}")
    private Integer id;
    @Value("${name}")
    private String name;
}
