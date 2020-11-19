package com.mjlf.mybatis;

import com.mjlf.mybatis.datasource.BlogDataSourceFactory;
import com.mjlf.mybatis.mapper.BlogMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Mybatis
 * @Author mjlft
 * @Date 2020/5/13 19:59
 * @Version 1.0
 * @Description 基于非xml的方式构建sqlSessionFactory
 */
public class MybatisDataSourceTest {
    public static void main(String[] args) throws IOException {
        //创建DataSource
        DataSource dataSource = BlogDataSourceFactory.getDataSource();
        //创建传输工厂
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建mybatis环境
        Environment environment = new Environment("development", transactionFactory, dataSource);

        //将环境配置设置到配置类种
        Configuration configuration = new Configuration(environment);
        //向配置类种添加Mapper
        configuration.addMapper(BlogMapper.class);

        //通过配置类拿到SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        //拿到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //拿到Mapper，然后进行方法调用
        System.out.println(sqlSession.getMapper(BlogMapper.class).selectBlog("1"));
    }
}
