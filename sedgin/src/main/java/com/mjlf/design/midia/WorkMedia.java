package com.mjlf.design.midia;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName WorkMedia
 * @Author mjlft
 * @Date 2020/11/26 18:48
 * @Version 1.0
 * @Description TODO
 */
public class WorkMedia implements Media {

    private Map<String, College> map = new HashMap<>();

    @Override
    public void registry(String name, College college) {
        map.put(name, college);
    }

    @Override
    public void getMessage(String string) {
        this.map.get(string).getMessage();
    }

    @Override
    public void sendMessage(String name) {
        this.map.get(name).getMessage();
    }
}
