package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式，懒汉式，线程安全， 同步方法
 * 优点：第一次使用时创建，线程安全
 * 缺点：同步方法，锁粒度太大
 */
public class SingletonType4 {
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getSingleton2();
        Singleton2 singleton21 = Singleton2.getSingleton2();

        System.out.println(singleton2 == singleton21);
    }
}

class Singleton2{
    private static Singleton2 singleton2;
    private Singleton2(){}

    public synchronized static Singleton2 getSingleton2() {
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}