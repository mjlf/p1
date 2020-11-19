package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式，饿汉式，静态方法块
 * 优点：不存在线程安全问题， 在类加载的时候就进行了对象实例化，并且实现起来很简单
 * 缺点：可能会造成内存浪费， 在类加载时进行对象实例， 但是这个对象可能永远都用不到，做不到懒加载
 */
public class SingletonType2 {
    public static void main(String[] args) {
        Single2 single2 = Single2.getInstance();
        Single2 single21 = Single2.getInstance();

        System.out.println(single2 == single21);
    }
}

//饿汉式，静态变量
class Single2{
    private Single2(){}

    private static Single2 single1;

    static {
        single1 = new Single2();
    }

    public static Single2 getInstance(){
        return single1;
    }
}
