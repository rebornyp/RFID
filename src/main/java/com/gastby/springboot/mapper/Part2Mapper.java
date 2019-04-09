package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Part2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Part2Mapper {

    @Select("select * from part where tid is null")
    List<Part2> queryUnBindTags();

    @Insert("insert part (pid, name, type, info, producer, produceDate) " +
            "values(#{pid}, #{name}, #{type}, #{info}, #{producer}, #{produceDate})")
    void insertPart(Part2 part2);

    @Select("select * from part")
    List<Part2> queryAllParts();

    @Update("update part set tid=#{tid} where id=#{id}")
    void updateTagInfo(@Param(value="id")Integer id, @Param(value="tid")String tid);
}
