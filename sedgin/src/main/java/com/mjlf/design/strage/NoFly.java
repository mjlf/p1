package com.mjlf.design.strage;

/**
 * @ClassName NoFly
 * @Author mjlft
 * @Date 2020/11/27 13:57
 * @Version 1.0
 * @Description TODO
 */
public class NoFly implements Fly {

    @Override
    public void ff() {
        System.out.println("不能非");
    }
}
