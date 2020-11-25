package com.mjlf.design.componment;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Scheel
 * @Author mjlft
 * @Date 2020/11/25 14:48
 * @Version 1.0
 * @Description TODO
 */
public class Unity extends ACompoment {

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void show(){
        System.out.println(name + ":" + desc);
        unit.keySet().forEach(key->{
            unit.get(key).show();
        });
    }

    public Unity(String name, String des) {
        super(name, des);
    }

    private Map<String, Componment> unit = new HashMap<>();

    @Override
    public void add(Componment componment) {
        if(componment instanceof Stu){
            unit.put(((Stu)(componment)).getName(), componment);
        }else {
            super.add(componment);
        }
    }

    @Override
    public void remove(Componment componment) {
        if(componment instanceof Stu){
            unit.remove(((Stu)(componment)).getName());
        }else {
            super.remove(componment);
        }
    }
}
