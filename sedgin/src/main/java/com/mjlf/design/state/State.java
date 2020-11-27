package com.mjlf.design.state;

/**
 * @ClassName State
 * @Author mjlft
 * @Date 2020/11/27 12:35
 * @Version 1.0
 * @Description TODO
 */
public abstract class State {
    protected Actity actity;

    public State(Actity actity) {
        this.actity = actity;
    }

    public abstract boolean disCount();

    public abstract void doInvoke();

    public abstract void callback();
}
