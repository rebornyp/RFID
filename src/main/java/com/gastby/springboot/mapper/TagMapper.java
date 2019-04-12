package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {

    @Insert("insert tag (tid, type, birthDate) " +
            "values(#{tid}, #{type}, #{birthDate})")
    void insertPart(Tag tag);

    @Select("select * from tag")
    List<Tag> queryAllTags();

    @Select("select * from tag where partId is null")
    List<Tag> queryUnBindTags();

    @Update("update tag set partId = #{partId} where id = #{id}")
    void updatePartInfo(@Param(value="id")Integer id, @Param(value="partId")String pid);

    @Select("select partId from tag where tid = #{id}")
    String queryPartIdByTagId(@Param(value = "id") String tagId);
}
