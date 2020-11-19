package com.mjlf.jmx.mben;

/**
 * @ClassName Hello
 * @Author mjlft
 * @Date 2020/5/21 22:45
 * @Version 1.0
 * @Description TODO
 */
public class Hello implements HelloMBean {

    @Override
    public void sayHello(String name) {
        System.out.println("HELLO - " + name);
    }

    @Override
    public void sayByeBye(String name) {
        System.out.println("Good Bye - " + name);
    }
}
