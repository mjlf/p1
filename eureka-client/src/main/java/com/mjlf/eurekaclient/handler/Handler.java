package com.mjlf.eurekaclient.handler;

import com.mjlf.eurekaclient.entity.User;
import com.mjlf.eurekaclient.util.Users;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Mono;

import javax.servlet.ServletException;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @ClassName Handler
 * @Author mjlft
 * @Date 2020/8/23 17:46
 * @Version 1.0
 * @Description TODO
 */
@Component
public class Handler {

    public ServerResponse getAllUser(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Users.getAllUser());
    }

    public ServerResponse createUser(ServerRequest request) throws ServletException, IOException {
        User user = request.body(User.class);
        System.out.println(user);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user);
    }
}
