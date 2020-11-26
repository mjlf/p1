package com.mjlf.design.command;

/**
 * @ClassName LightOnCommand
 * @Author mjlft
 * @Date 2020/11/26 13:14
 * @Version 1.0
 * @Description 电灯关命令
 */
public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void exec() {
        this.light.off();
    }

    @Override
    public void undo() {
        this.light.on();
    }
}
