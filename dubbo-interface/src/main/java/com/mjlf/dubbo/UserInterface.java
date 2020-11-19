package com.mjlf.dubbo;

import com.mjlf.dubbo.entity.User;

/**
 * @ClassName UserInterface
 * @Author mjlft
 * @Date 2020/5/6 16:36
 * @Version 1.0
 * @Description TODO
 */
public interface UserInterface {

    String getName(String name);

    User getUser(int id);
}
