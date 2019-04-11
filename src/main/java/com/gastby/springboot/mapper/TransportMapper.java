package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.TransportPojo;
import com.gastby.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TransportMapper {

    @Insert("insert transport (tid, listId, readerId, startTime, endTime, startHouse, endHouse, worker, info) " +
            "values(#{tid}, #{listId}, #{readerId}, #{startTime}, #{endTime}, #{startHouse}, #{endHouse}, #{worker},#{info})")
    void insertTransport(TransportPojo transportPojo);

    @Select("select * from transport")
    List<TransportPojo> queryAllTransportMissions();

/*
    @Select("select * from user where id = #{id} limit 1")
    User queryUserById(@Param(value = "id") Integer id);

    @Update("update user set userId=#{userId}, name=#{name}, password=#{password}," +
            " level=#{level}, mailbox=#{mailBox}, gender=#{gender}, info=#{info} where id=#{id}")
    void updateUserById(User user);*/
}
