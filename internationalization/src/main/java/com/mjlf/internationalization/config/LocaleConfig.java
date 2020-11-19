package com.mjlf.internationalization.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

//@Configuration(proxyBeanMethods = false)
public class LocaleConfig {

//    @Bean
//    public LocaleResolver localeResolver() {
//
//        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//
//        localeResolver.setCookieName("localeCookie");
//
//        //设置默认区域
////        localeResolver.setDefaultLocale(Locale.ENGLISH);
//
//        localeResolver.setCookieMaxAge(3600);//设置cookie有效期.
//
//        return localeResolver;
//    }
}