package com.mjlf.dubbocomsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mjlf.dubbo.UserInterface;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserInterface userService;

    @RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name) {
        return userService.getName(name);
    }

}