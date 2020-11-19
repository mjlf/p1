package com.mjlf.eurekaclient.conig;

import com.mjlf.eurekaclient.handler.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

/**
 * @ClassName Rounters
 * @Author mjlft
 * @Date 2020/8/23 18:06
 * @Version 1.0
 * @Description TODO
 */
@Configuration
public class Rounters {

    @Autowired
    private Handler handler;

    @Bean
    public RouterFunction<ServerResponse> userRoute(){
        return RouterFunctions.nest(RequestPredicates.path("/user"),
                RouterFunctions.route(RequestPredicates.GET("/allUser"), handler::getAllUser))
                .andRoute(RequestPredicates.POST("/createUser"), handler::createUser);
    }
}
