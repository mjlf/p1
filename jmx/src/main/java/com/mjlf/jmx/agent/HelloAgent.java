package com.mjlf.jmx.agent;

import com.mjlf.jmx.mben.Hello;
import com.sun.jdmk.comm.HtmlAdaptorServer;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @ClassName HelloAgent
 * @Author mjlft
 * @Date 2020/5/21 22:51
 * @Version 1.0
 * @Description TODO
 */
public class HelloAgent {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        //1. 开启MBean服务
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
       //2.设置domain名称
        String domainName = "MyMBean";

        //创建对象名称
        ObjectName helloName = new ObjectName(domainName+":name=HelloWorld");
        //注册Mbean到server
        mBeanServer.registerMBean(new Hello(),helloName);

        //httpAdapter注册
        ObjectName adapterName = new ObjectName(domainName+":name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        adapter.start();
        mBeanServer.registerMBean(adapter,adapterName);

        //rmi注册
        int rmiPort = 1099;
        Registry registry = LocateRegistry.createRegistry(rmiPort);

        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:"+rmiPort+"/"+domainName);
        JMXConnectorServer jmxConnector = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mBeanServer);
        jmxConnector.start();
    }
}
