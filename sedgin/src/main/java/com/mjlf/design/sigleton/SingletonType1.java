package com.mjlf.design.sigleton;

/**
 * @ClassName SingletonType1
 * @Author mjlft
 * @Date 2020/11/19 10:08
 * @Version 1.0
 * @Description 单例模式，饿汉式，静态常量
 * 优点：不存在线程安全问题， 在类加载的时候就进行了对象实例化，并且实现起来很简单
 * 缺点：可能会造成内存浪费， 在类加载时进行对象实例， 但是这个对象可能永远都用不到，做不到懒加载
 */
public class SingletonType1 {
    public static void main(String[] args) {
        Single1 single1 = Single1.getInstance();
        Single1 single12 = Single1.getInstance();

        System.out.println(single1 == single12);
    }
}

//饿汉式，静态变量
class Single1{
    private Single1(){}

    private final static Single1 single1 = new Single1();

    public static Single1 getInstance(){
        return single1;
    }
}
