package com.mjlf.design.lian;

/**
 * @ClassName Filter
 * @Author mjlft
 * @Date 2020/11/27 14:50
 * @Version 1.0
 * @Description TODO
 */
public  class None extends Filter{

    public None(Filter filter) {
       super(filter);
    }

    public boolean doFileter(){
        System.out.println("空链");
        return true;
    }
}
