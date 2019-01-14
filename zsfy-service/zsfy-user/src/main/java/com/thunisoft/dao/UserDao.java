package com.thunisoft.dao;

import com.thunisoft.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select  * from user where id = #{id}")
    User findUser(String id);

}
