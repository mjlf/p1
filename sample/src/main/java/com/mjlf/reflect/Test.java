package com.mjlf.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/10/9 17:42
 * @Version 1.0
 * @Description TODO
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ReflectTest reflectTest = ReflectTest.class.newInstance();
        Method method = ReflectTest.class.getDeclaredMethod("getEntity");
        method.setAccessible(true);
        Entity entity = (Entity) method.invoke(reflectTest);
        System.out.println(entity);
    }
}
