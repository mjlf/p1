package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式, 静态内部类
 * 优点：第一次使用时创建，线程安全
 * 缺点：
 * 原理：静态内部类在外层类加载的时候不会加载
 *      类在加载的时候时线程安全的，只能由一个内进行加载
 */
public class SingletonType6 {
    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = StaticInnerClass.getStaticInnerClass();
        StaticInnerClass staticInnerClass1 = StaticInnerClass.getStaticInnerClass();

        System.out.println(staticInnerClass == staticInnerClass1);
    }
}

class StaticInnerClass{
    private static StaticInnerClass staticInnerClass;

    private StaticInnerClass(){};

    public static StaticInnerClass getStaticInnerClass() {
        return InnerClass.staticInnerClass;
    }

    //静态内部类
    static class InnerClass {
        private static StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}