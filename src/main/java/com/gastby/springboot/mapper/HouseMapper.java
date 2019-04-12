package com.gastby.springboot.mapper;

import com.gastby.springboot.entities.House;
import com.gastby.springboot.entities.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HouseMapper {

/*    @Insert("insert tag (tid, type, birthDate) " +
            "values(#{tid}, #{type}, #{birthDate})")
    void insertPart(Tag tag);*/

    @Select("select * from store")
    List<House> queryAllHouse();

    @Select("select storeId from store where name = #{name}")
    String queryHouseIdByName(@Param(value = "name") String a);

    @Select("select name from store where storeId = #{storeId}")
    String queryHouseNameById(@Param(value = "storeId") String a);

    @Select("select reader from store where storeId = #{id}")
    String queryReaderById(@Param(value = "id") String curHouseId);
}
