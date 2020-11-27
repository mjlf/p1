package com.mjlf.design.state;

/**
 * @ClassName Actity
 * @Author mjlft
 * @Date 2020/11/27 12:34
 * @Version 1.0
 * @Description TODO
 */
public class Actity {

    public State state = null;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void doV(){
        this.state.doInvoke();
    }
}
