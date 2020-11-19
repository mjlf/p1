package com.mjlf.jetty;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyServlet
 * @Author mjlft
 * @Date 2020/6/3 17:36
 * @Version 1.0
 * @Description TODO
 */
@WebServlet(name = "asnycServlet", value = "/asyncServlet")
public class AsyncServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        //拿到异步支持上下文
        AsyncContext asyncContext = req.startAsync();
        //异步执行任务
        CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
                HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();

                response.getWriter().write("done");

                asyncContext.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
