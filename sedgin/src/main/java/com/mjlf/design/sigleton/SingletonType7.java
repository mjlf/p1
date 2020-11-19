package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式, 枚举
 * 优点：第一次使用时创建，线程安全
 */
public class SingletonType7 {
    public static void main(String[] args) {
        Singleton4 singleton4 = Singleton4.Single.getInstance();
        Singleton4 singleton41 = Singleton4.Single.getInstance();

        System.out.println(singleton4 == singleton41);
    }
}

class Singleton4{
    private Singleton4(){}
    enum Single{
        INSTANCE(new Singleton4());
        private Singleton4 singleton4;

        Single(Singleton4 singleton4) {
            this.singleton4 = singleton4;
        }
        public static Singleton4 getInstance(){
            return INSTANCE.singleton4;
        }
    }
}