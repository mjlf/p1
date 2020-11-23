package com.mjlf.design.adapter.objAdapter;

/**
 * @ClassName Phone
 * @Author mjlft
 * @Date 2020/11/23 10:00
 * @Version 1.0
 * @Description TODO
 */
public class Phone {
    private IVlagter5 vlagter5;

    public void setAdapter(IVlagter5 vlagter5) {
        this.vlagter5 = vlagter5;
    }

    public void cd(){
        if(vlagter5.output5() == 5){
            System.out.println("5V， 可以充电");
        }else {
            System.out.println("不能充电");
        }
    }
}
