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

    @Select("select * from transport where isDone = 0")
    List<TransportPojo> queryBusyMissions();

    @Select("select * from transport where startHouse = #{start} && endHouse = #{end}")
    List<TransportPojo> queryMissionsByPath(@Param(value = "start") String s, @Param(value = "end") String e);

}
