package com.thunisoft.dao;

import com.thunisoft.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where username=#{username}")
    User login(String username);

    @Select("select  * from user where id = #{id}")
    User findUser(String id);

    @Insert("insert into user(id, username, password, role) values(#{id}, #{username}, #{password}, #{role})")
    int saveUser(User user);
}
