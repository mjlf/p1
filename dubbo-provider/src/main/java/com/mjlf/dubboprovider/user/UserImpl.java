package com.mjlf.dubboprovider.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.mjlf.dubbo.UserInterface;
import com.mjlf.dubbo.entity.User;
import com.mjlf.dubboprovider.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName UserImpl
 * @Author mjlft
 * @Date 2020/5/6 16:49
 * @Version 1.0
 * @Description TODO
 */
@Service(interfaceClass = UserInterface.class)
public class UserImpl implements UserInterface {

    @Autowired
    private UserDao userDao;

    @Override
    public String getName(String name) {
        return "hello " + name;
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
