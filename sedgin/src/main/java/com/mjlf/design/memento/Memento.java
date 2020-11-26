package com.mjlf.design.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Memento
 * @Author mjlft
 * @Date 2020/11/26 19:42
 * @Version 1.0
 * @Description TODO
 */
public class Memento {

    Map<String, String> map = new HashMap<>();

    public void save(String name, String state){
        map.put(name, state);
    }

    public String getState(String name){
        return map.get(name);
    }
}
