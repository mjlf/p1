package com.mjlf.design.builder;

/**
 * @ClassName ChinaHourseBuilder
 * @Author mjlft
 * @Date 2020/11/20 16:59
 * @Version 1.0
 * @Description TODO
 */
public class AMHourseBuilder implements HouserBuilder{
    Hourse hourse;
    @Override
    public void flow1(Hourse hourse) {
        System.out.println("美房1");
    }

    @Override
    public void flow2(Hourse hourse) {
        System.out.println("美房2");
    }

    @Override
    public void flow3(Hourse hourse) {
        System.out.println("美房3");
    }
}
