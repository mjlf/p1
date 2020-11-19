package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式，懒汉式，线程安全， 同步代码块
 * 优点：第一次使用时创建，线程安全
 * 缺点：
 */
public class SingletonType5 {
    public static void main(String[] args) {
        Singleton3 singleton3 = Singleton3.getSingleton3();
        Singleton3 singleton31 = Singleton3.getSingleton3();

        System.out.println(singleton3 == singleton31);
    }
}

class Singleton3{
    private static Singleton3 singleton3;

    public static Singleton3 getSingleton3() {
        if(singleton3 == null){
            synchronized (Singleton3.class){
                if(singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}