package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Part;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PartMapper {

    @Insert("insert part (pid, tid, name, birthDate, producer, position) " +
            "values(#{pid}, #{tid}, #{name}, #{birthDate}, #{producer}, #{position})")
    void insertPart(Part part);

    @Select("select * from part")
    List<Part> queryAllParts();

}
