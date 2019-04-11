package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.Part2;
import com.gastby.springboot.entities.PartList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PartListMapper {

    @Select("select * from partlist")
    List<PartList> queryAllPartList();

    //@Select("select * from partlist where partListId = #{id}")
    @Select("select part.id, part.pid, part.tid, part.name, part.type, " +
            "part.info, part.producer, part.produceDate " +
            "from part inner join partlist where part.pid=partlist.partId " +
            "&& partlist.partListId=#{id};")
    List<Part2> queryPartListById(@Param(value = "id") String temp);

}
