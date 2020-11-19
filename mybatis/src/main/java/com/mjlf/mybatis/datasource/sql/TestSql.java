package com.mjlf.mybatis.datasource.sql;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

/**
 * @ClassName Test
 * @Author mjlft
 * @Date 2020/5/25 16:36
 * @Version 1.0
 * @Description TODO
 */
public class TestSql {
    public String getStart(){
        SQL sql = new SQL();
        sql.DELETE_FROM("xxx").WHERE("xxx").AND().WHERE("xxxx");
        System.out.println(sql.toString());
        return "";
    }
    @Test
    public void tes(){
        getStart();
    }
}
