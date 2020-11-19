package com.mjlf.design.factory;

/**
 * @ClassName Pizza
 * @Author mjlft
 * @Date 2020/11/19 15:55
 * @Version 1.0
 * @Description 披萨
 */
public interface Pizza {

    //材料准备
    void prepare();

    //烹饪
    void cookie();

    //切割
    void cut();

    //打包
    void box();

    //制作
    default void invoke(){
        prepare();
        cookie();
        cut();
        box();
        System.out.println("披萨制作完成");
    }
}
