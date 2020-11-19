package com.mjlf.dubbocomsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mjlf.dubbo.UserInterface;
import com.mjlf.dubbo.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserInterface userService;

    @RequestMapping(value = "/sayHello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name) {
        return userService.getName(name);
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") int id) throws Exception {
        if(System.currentTimeMillis() % 2 == 0){
            TimeUnit.SECONDS.sleep(2);
        }
        return userService.getUser(id);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(@PathVariable("id") int id) {
        System.out.println("error");
        return "ok";
    }
}