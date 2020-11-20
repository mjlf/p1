package com.mjlf.design.prototype;

import java.io.Serializable;

/**
 * @ClassName InatanceB
 * @Author mjlft
 * @Date 2020/11/20 12:32
 * @Version 1.0
 * @Description TODO
 */
public class InatanceB implements Serializable, Cloneable {
    private int a;
    private Instance instance;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "InatanceB{" +
                "a=" + a +
                ", instance=" + instance +
                '}';
    }
}
