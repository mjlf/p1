package com.mjlf.nacosprovider.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private double money;
}