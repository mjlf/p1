package com.mjlf.skywalking.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.mjlf.skywalking.entity.User;
import com.mjlf.skywalking.service.LocalCacheVerifier;
import com.mjlf.skywalking.service.UserService;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosInjected
    private NamingService namingService;

    @Autowired
    private LocalCacheVerifier localCacheVerifier;

    @Value("${my.uuid}")
    private String uuid;

    @GetMapping("/getAllInstance")
    @ResponseBody
    public List<Instance> getAllInstance(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    @GetMapping("/getNacosValue")
    public boolean getNacosValue(){
        System.out.println(uuid);
        localCacheVerifier.checkLocalCache();
        return useLocalCache;
    }

    @RequestMapping("/insert")
    public List<User> testInsert() {
        userService.insertService();
        return userService.selectAllUser();
    }

    @RequestMapping("/query")
    public User testQuery() {
        return userService.selectUserByName("Daisy");
    }


    @RequestMapping("/changemoney")
    public List<User> testchangemoney() {
        userService.changemoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }

    @RequestMapping(value = "/traceId", method = RequestMethod.GET)
    public String traceId(){
        //打印日志消息
        ActiveSpan.debug("heheh");
        ActiveSpan.error("heheh");
        ActiveSpan.info("heheh");
        return TraceContext.traceId();
    }
}