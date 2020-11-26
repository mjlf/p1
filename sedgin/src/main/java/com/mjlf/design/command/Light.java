package com.mjlf.design.command;

/**
 * @ClassName Light
 * @Author mjlft
 * @Date 2020/11/26 13:15
 * @Version 1.0
 * @Description 电灯， 命令接收者
 */
public class Light {
    public void on(){
        System.out.println("电灯开");
    }

    public void off(){
        System.out.println("电灯关");
    }
}
