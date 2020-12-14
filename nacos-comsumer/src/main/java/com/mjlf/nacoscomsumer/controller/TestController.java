package com.mjlf.nacoscomsumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mjlf.nacoscomsumer.feign.FeignTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    @Autowired
    private FeignTest feignTest;

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://example/echo/" + str, String.class);
    }

    @GetMapping("get")
    public String getConfig(){
        System.out.println("abc");
        return feignTest.getConfig();
    }

    @SentinelResource(value = "cloudSentinel", blockHandler = "cloudSentinelExec")
    @GetMapping("cloudSentinel")
    public String cloudSentinel(){
        return "yes";
    }

    public String cloudSentinelExec(BlockException e){
        return "no";
    }
}