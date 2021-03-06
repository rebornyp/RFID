package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.MonitorRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MonitorRecordMapper {

    @Select("select * from monitor where readerId = #{id}")
    List<MonitorRecord> queryAllRecordsByReaderId(@Param(value = "id")String readerId);


    @Select("select * from monitor")
    List<MonitorRecord> queryAllRecords();

    @Insert("insert monitor (readerId, tagId, info, startTime, endTime, worker) " +
            "values(#{readerId}, #{tagId}, #{info}, #{startTime}, #{endTime}, #{worker})")
    void insertPart(MonitorRecord record);


}
