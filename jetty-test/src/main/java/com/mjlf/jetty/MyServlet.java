package com.mjlf.jetty;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyServlet
 * @Author mjlft
 * @Date 2020/6/3 17:36
 * @Version 1.0
 * @Description TODO
 */
//@WebServlet(name = "myServlet", value = "/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("xxx");
        res.getWriter().write("yes");
//        super.service(req, res);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
