package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Part2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Part2Mapper {

    @Insert("insert part (pid, name, type, info, producer, produceDate) " +
            "values(#{pid}, #{name}, #{type}, #{info}, #{producer}, #{produceDate})")
    void insertPart(Part2 part2);

    @Select("select * from part")
    List<Part2> queryAllParts();

}
