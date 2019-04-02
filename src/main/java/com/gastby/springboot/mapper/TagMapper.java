package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {

    @Insert("insert tag (tid, type, birthDate) " +
            "values(#{tid}, #{type}, #{birthDate})")
    void insertPart(Tag tag);

    @Select("select * from tag")
    List<Tag> queryAllTags();

}
