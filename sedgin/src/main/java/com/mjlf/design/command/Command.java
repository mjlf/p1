package com.mjlf.design.command;

/**
 * @ClassName Command
 * @Author mjlft
 * @Date 2020/11/26 13:13
 * @Version 1.0
 * @Description 命令接口
 */
public interface Command {
    void exec();
    void undo();
}
