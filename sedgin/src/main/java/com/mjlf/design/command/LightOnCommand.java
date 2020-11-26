package com.mjlf.design.command;

/**
 * @ClassName LightOnCommand
 * @Author mjlft
 * @Date 2020/11/26 13:14
 * @Version 1.0
 * @Description 电灯开接口
 */
public class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void exec() {
        this.light.on();
    }

    @Override
    public void undo() {
        this.light.off();
    }
}
