package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Part;
import com.gastby.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert user (userId, name, password, level, mailbox, gender, info) " +
            "values(#{userId}, #{name}, #{userPwd}, #{level}, #{mailBox}, #{gender}, #{info})")
    void insertUser(User user);

    @Select("select * from user")
    List<User> queryAllUsers();
}
