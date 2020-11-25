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
public class Stu extends ACompoment {


    public String getName() {
        return name;
    }

    public Stu(String name, String des) {
       super(name, des);
    }

    public void show(){
        System.out.println(name+":" + desc);
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", des='" + desc + '\'' +
                '}';
    }
}
