package com.mjlf.design.vistor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Count
 * @Author mjlft
 * @Date 2020/11/26 14:31
 * @Version 1.0
 * @Description TODO
 */
public class Count {

    public List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }
}
