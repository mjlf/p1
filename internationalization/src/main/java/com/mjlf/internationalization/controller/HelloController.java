package com.mjlf.internationalization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class HelloController {
    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) throws Exception {
        if(new Random().nextBoolean())
        throw new Exception();
        return messageSource.getMessage("user.name", null, RequestContextUtils.getLocale(request));
    }

    @GetMapping("/mono")
    public Mono<String> mono(){
        System.out.println(System.currentTimeMillis());
        Mono<String> res = Mono.fromSupplier(()-> create());
        System.out.println(System.currentTimeMillis());
        return res;
    }

    @GetMapping(value = "/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> flow(){
       return Flux.fromStream(IntStream.range(1, 10).mapToObj(i -> {
           try {
               TimeUnit.SECONDS.sleep(3);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           return "flab -> " + i;
       }));
    }

    public String create(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "abc";
    }
}