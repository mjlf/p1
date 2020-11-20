package com.mjlf.design.prototype;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/20 12:33
 * @Version 1.0
 * @Description TODO
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        InatanceB inatanceB = new InatanceB();
        Instance instance = new Instance();
        inatanceB.setInstance(instance);

        System.out.println(inatanceB);
        System.out.println(inatanceB.clone());

        System.out.println(instance.hashCode());
        System.out.println(inatanceB.copyInstanceB().getInstance().hashCode());
        System.out.println(inatanceB.copyInstanceB());
    }
}
