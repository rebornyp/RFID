package com.gastby.springboot.mapper;

import com.gastby.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert user (userId, name, password, level, mailbox, gender, info) " +
            "values(#{userId}, #{name}, #{password}, #{level}, #{mailBox}, #{gender}, #{info})")
    void insertUser(User user);

    @Select("select * from user")
    List<User> queryAllUsers();

    @Select("select * from user where id = #{id} limit 1")
    User queryUserById(@Param(value="id")Integer id);

    @Update("update user set userId=#{userId}, name=#{name}, password=#{password}," +
            " level=#{level}, mailbox=#{mailBox}, gender=#{gender}, info=#{info} where id=#{id}")
    void updateUserById(User user);
}
