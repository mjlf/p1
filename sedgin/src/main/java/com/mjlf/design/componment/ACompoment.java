package com.mjlf.design.componment;

/**
 * @ClassName ACompoment
 * @Author mjlft
 * @Date 2020/11/25 14:47
 * @Version 1.0
 * @Description TODO
 */
public class ACompoment implements Componment {

    protected String name;
    protected String desc;

    public ACompoment(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void show(){
        System.out.println(name+":"+desc);
    }

    @Override
    public void add(Componment componment) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Componment componment) {
        throw new UnsupportedOperationException();
    }
}
