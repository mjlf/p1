package com.mjlf.design.adapter.classAdapter;

/**
 * @ClassName Phone
 * @Author mjlft
 * @Date 2020/11/23 10:00
 * @Version 1.0
 * @Description TODO
 */
public class Phone {
    private IVlagter5 adapter;

    public void setAdapter(IVlagter5 adapter) {
        this.adapter = adapter;
    }

    public void cd(){
        if(adapter.output5() == 5){
            System.out.println("5V， 可以充电");
        }else {
            System.out.println("不能充电");
        }
    }
}
