package com.mjlf.mybatis.datasource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @ClassName BlogDataSource
 * @Author mjlft
 * @Date 2020/5/13 20:24
 * @Version 1.0
 * @Description TODO
 */
public class BlogDataSourceFactory {

    public static DataSource getDataSource(){
       DataSourceFactory dataSourceFactory = new PooledDataSourceFactory();

        Properties properties = new Properties();
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://172.21.39.186:3306/test");

       dataSourceFactory.setProperties(properties);
       return dataSourceFactory.getDataSource();
    }
}
