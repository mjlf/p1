package com.mjlf.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/get")
    public String get() {
        return applicationContext.getEnvironment().getProperty("abc.text");
    }
}