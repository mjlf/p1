package com.mjlf.design.bridge;

/**
 * @ClassName LStyle
 * @Author mjlft
 * @Date 2020/11/25 11:53
 * @Version 1.0
 * @Description TODO
 */
public class LStyle implements Style{
    @Override
    public void call() {
        System.out.println("L Call");
    }

    @Override
    public void shutdown() {
        System.out.println("L shutdown");
    }
}
