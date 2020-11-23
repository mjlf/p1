package com.mjlf.design.adapter.objAdapter;

/**
 * @ClassName Adapter
 * @Author mjlft
 * @Date 2020/11/23 9:59
 * @Version 1.0
 * @Description 适配类
 */
public class Adapter implements IVlagter5 {

    private Vlatger220 vlatger220;

    public Adapter(Vlatger220 vlatger220) {
        this.vlatger220 = vlatger220;
    }

    @Override
    public int output5() {
        return this.vlatger220.output() / 44;
    }
}
