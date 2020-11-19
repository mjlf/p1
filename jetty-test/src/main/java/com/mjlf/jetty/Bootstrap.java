package com.mjlf.jetty;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @ClassName Bootstrap
 * @Author mjlft
 * @Date 2020/6/3 8:42
 * @Version 1.0
 * @Description jetty 启动类
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.setStopAtShutdown(true);

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        connector.setReuseAddress(true);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(MyServlet.class, "/syncServlet" );
        context.addServlet(AsyncServlet.class, "/asyncServlet" );

        server.setConnectors(new Connector[]{connector});
//        server.setHandler(new HelloWorldHandle());

        server.start();
        server.join();
    }
}
