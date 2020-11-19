package com.mjlf.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/5/26 11:27
 * @Version 1.0
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Source helloWorld = new ByteBuddy()
                .subclass(Source.class)
                .method(ElementMatchers.<MethodDescription>named("hello")).intercept(MethodDelegation.to(Target.class))
                .defineField("abc", Integer.class, Visibility.PUBLIC) // 定义一个属性字段
                .make()
                .load(Source.class.getClassLoader())
                .getLoaded()
                .newInstance();

    }
}
