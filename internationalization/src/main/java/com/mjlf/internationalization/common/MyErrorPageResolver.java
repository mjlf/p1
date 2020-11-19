package com.mjlf.internationalization.common;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles3.TilesView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName MyErrorPageResolver
 * @Author mjlft
 * @Date 2020/8/13 23:36
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyErrorPageResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        if(status.value() == 500){
            System.out.println("yes");
            return new ModelAndView("500", model);
        }
        return null;
    }
}
