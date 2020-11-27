package com.mjlf.design.lian;

/**
 * @ClassName Filter
 * @Author mjlft
 * @Date 2020/11/27 14:50
 * @Version 1.0
 * @Description TODO
 */
public  class OneFilter extends Filter{

    public OneFilter(Filter filter) {
       super(filter);
    }

    public boolean doFileter(){
        System.out.println("第一个条连接");
        this.filter.doFileter();
        return true;
    }
}
