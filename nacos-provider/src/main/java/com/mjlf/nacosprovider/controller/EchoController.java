package com.mjlf.nacosprovider.controller;

import com.mjlf.nacosprovider.service.UserService;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EchoController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        System.out.println(userService.selectAllUser());

        //打印日志消息
        ActiveSpan.debug("heheh");
        ActiveSpan.error("heheh");
        ActiveSpan.info("heheh");
        return "Hello Nacos Discovery " + string + " TraceId:" + TraceContext.traceId();
    }
}