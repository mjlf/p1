package com.mjlf.design.prototype;

import java.io.Serializable;

/**
 * @ClassName Instance
 * @Author mjlft
 * @Date 2020/11/20 12:30
 * @Version 1.0
 * @Description TODO
 */

public class Instance implements Serializable, Cloneable {
    private int a;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Instance{" +
                "a=" + a +
                '}';
    }
}
