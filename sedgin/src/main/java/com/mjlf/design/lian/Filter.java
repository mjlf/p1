package com.mjlf.design.lian;

import com.mjlf.design.vistor.Faile;

/**
 * @ClassName Filter
 * @Author mjlft
 * @Date 2020/11/27 14:50
 * @Version 1.0
 * @Description TODO
 */
public abstract class Filter {

    protected Filter filter;

    public Filter(Filter filter) {
        this.filter = filter;
    }

    public abstract boolean doFileter();
}
