package com.mjlf.dubbo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author mjlft
 * @Date 2020/5/25 20:00
 * @Version 1.0
 * @Description TODO
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
}
