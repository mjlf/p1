package com.mjlf.mybatis.mapper;

import com.mjlf.mybatis.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName BlogMap
 * @Author mjlft
 * @Date 2020/5/13 20:03
 * @Version 1.0
 * @Description
 */
@Mapper
public interface BlogMapper {
    @Select("SELECT * FROM blog where id = #{id}")
    Blog selectBlog(String id);
}
