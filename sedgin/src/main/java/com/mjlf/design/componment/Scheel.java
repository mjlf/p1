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
public class Scheel extends ACompoment {

    public Scheel(String name, String desc) {
        super(name, desc);
    }

    private Map<String, Componment> unit = new HashMap<>();

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + ":" + desc);
        unit.keySet().forEach(key -> {
            unit.get(key).show();
        });
    }


    @Override
    public void add(Componment componment) {
        if (componment instanceof Unity) {
            unit.put(((Unity) (componment)).getName(), componment);
        } else {
            super.add(componment);
        }
    }

    @Override
    public void remove(Componment componment) {
        if (componment instanceof Unity) {
            unit.remove(((Unity) (componment)).getName());
        } else {
            super.remove(componment);
        }
    }
}
