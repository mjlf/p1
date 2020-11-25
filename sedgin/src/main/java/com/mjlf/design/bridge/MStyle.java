package com.mjlf.design.bridge;

/**
 * @ClassName LStyle
 * @Author mjlft
 * @Date 2020/11/25 11:53
 * @Version 1.0
 * @Description TODO
 */
public class MStyle implements Style{
    @Override
    public void call() {
        System.out.println("M Call");
    }

    @Override
    public void shutdown() {
        System.out.println("M shutdown");
    }
}
