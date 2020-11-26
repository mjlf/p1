package com.mjlf.design.memento;

/**
 * @ClassName Obj
 * @Author mjlft
 * @Date 2020/11/26 19:42
 * @Version 1.0
 * @Description TODO
 */
public class Obj {

    private String state;
    private Memento memento;

    public Obj(String state) {
        this.state = state;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    public void saveState(){
        this.memento.save("xx", this.state);
    }

    public void getStateFromMemento(){
        this.state = this.memento.getState("xx");
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "state='" + state + '\'' +
                '}';
    }
}
