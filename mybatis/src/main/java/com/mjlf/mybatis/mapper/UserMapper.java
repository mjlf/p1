package com.mjlf.mybatis.mapper;

import com.mjlf.mybatis.entity.User;

/**
 * @ClassName BlogMap
 * @Author mjlft
 * @Date 2020/5/13 20:03
 * @Version 1.0
 * @Description
 */
public interface UserMapper {
    User selectUser(String id);
}
