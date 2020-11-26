package com.mjlf.design.vistor;

/**
 * @ClassName User
 * @Author mjlft
 * @Date 2020/11/26 14:29
 * @Version 1.0
 * @Description TODO
 */
public class WoManUser extends User {

    public void setAction(Action action){
        System.out.println("女人给出状态" + action.getState());
    }
}
