package com.mjlf.design.command;

/**
 * @ClassName CommandController
 * @Author mjlft
 * @Date 2020/11/26 13:18
 * @Version 1.0
 * @Description TODO
 */
public class CommandController {
    private Command[] commands = new Command[5];
    private Command lastCommand = new UnCommand();

    public CommandController() {
        for(int i = 0; i < commands.length; i ++){
            commands[i] = new UnCommand();
        }
    }

    public void setCommands(int no, Command command){
        commands[no] = command;
    }

    public void exec(int no){
        commands[no].exec();
        lastCommand = commands[no];
    }

    public void ondo(){
        lastCommand.undo();
    }
}
