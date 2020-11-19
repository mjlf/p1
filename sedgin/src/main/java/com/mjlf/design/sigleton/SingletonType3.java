package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式，懒汉式，线程不安全
 * 优点：第一次使用时创建
 * 缺点：线程不安全， 在多线程情况下存在线程安全问题
 */
public class SingletonType3 {
    public static void main(String[] args) {
        SingletonE singletonE = SingletonE.getSingletonE();
        SingletonE singletonE1 = SingletonE.getSingletonE();

        System.out.println(singletonE == singletonE1);
    }
}

class SingletonE{
    private static SingletonE singletonE;
    private SingletonE(){}

    public static SingletonE getSingletonE() {
        if(singletonE == null){
            singletonE = new SingletonE();
        }
        return singletonE;
    }
}