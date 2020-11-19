package com.mjlf.dubboprovider.dao;

import com.mjlf.dubbo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName UserDao
 * @Author mjlft
 * @Date 2020/5/25 20:02
 * @Version 1.0
 * @Description TODO
 */
@Mapper
public interface UserDao {

    @Select("SELECT id, name from user where id = #{id}")
    User getUser(@Param("id") int id);
}
