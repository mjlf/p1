package com.mjlf.mybatis;

import com.mjlf.mybatis.entity.User;
import com.mjlf.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Mybatis
 * @Author mjlft
 * @Date 2020/5/13 19:59
 * @Version 1.0
 * @Description 基于xml配置类实现mybatis
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        //拿到配置文件内容信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //通过配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //拿到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到Mapper
        UserMapper blogMapper = sqlSession.getMapper(UserMapper.class);

        //执行方法调用
        User user = blogMapper.selectUser("1");
        System.out.println(user);
    }
}
