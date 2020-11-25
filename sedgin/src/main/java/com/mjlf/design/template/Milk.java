package com.mjlf.design.template;

/**
 * @ClassName Milk
 * @Author mjlft
 * @Date 2020/11/25 23:14
 * @Version 1.0
 * @Description TODO
 */
public abstract class Milk {
    public void start(){
        System.out.println("开始");
    }

    public abstract void invok();

    public void end(){
        System.out.println("结束");
    }

    public void sss(){
        start();
        invok();
        end();
    }
}
