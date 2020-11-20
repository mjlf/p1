package com.mjlf.design.builder;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/20 17:05
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        Hourse hourse = new Hourse();
        Manager manager = new Manager();
        manager.setHouserBuilder(new ChinaHourseBuilder());
        manager.buildhouser(hourse);
        System.out.println(hourse);
    }
}
