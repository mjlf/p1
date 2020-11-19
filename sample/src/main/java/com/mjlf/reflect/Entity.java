package com.mjlf.reflect;

/**
 * @ClassName Entity
 * @Author mjlft
 * @Date 2020/10/9 17:36
 * @Version 1.0
 * @Description TODO
 */
public class Entity {

    private String name;
    private String abc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", abc='" + abc + '\'' +
                '}';
    }
}
