package com.mjlf.design.midia;

/**
 * @ClassName Media
 * @Author mjlft
 * @Date 2020/11/26 18:42
 * @Version 1.0
 * @Description TODO
 */
public interface Media {

    void registry(String name, College college);
    void getMessage(String name);
    void sendMessage(String name);
}
