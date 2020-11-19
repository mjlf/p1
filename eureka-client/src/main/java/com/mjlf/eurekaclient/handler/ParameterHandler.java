package com.mjlf.eurekaclient.handler;

import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;


/**
 * @ClassName ParameterHandler
 * @Author mjlft
 * @Date 2020/8/23 19:23
 * @Version 1.0
 * @Description TODO
 */
@Service
@Order(-99)
public class ParameterHandler implements WebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        System.out.println("ssss");
        ServerHttpResponse response = serverWebExchange.getResponse();
        DataBuffer db = response.bufferFactory().wrap("ab".getBytes());
        return serverWebExchange.getResponse().writeWith(Mono.just(db));
    }
}
