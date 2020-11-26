package com.mjlf.design.command;

/**
 * @ClassName Client
 * @Author mjlft
 * @Date 2020/11/26 13:22
 * @Version 1.0
 * @Description TODO
 */
public class Client {

    public static void main(String[] args) {
        CommandController commandController = new CommandController();
        Light light = new Light();
        Command command = new LightOnCommand(light);
        Command command1 = new LightOffCommand(light);
        commandController.setCommands(0, command);
        commandController.setCommands(1, command1);



        commandController.exec(0);
        commandController.ondo();
        commandController.exec(1);

    }
}
