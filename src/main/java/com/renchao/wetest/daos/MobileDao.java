package com.renchao.wetest.daos;

import com.renchao.wetest.models.Mobile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MobileDao {
    String TABLE_NAME = "mobiles";
    String PARAMETERS = "id,name,init_time,status,system,size,cpu,memory,brand";
    String PARAMETERS_VALUES = "#{id}, #{name}, #{init_time},#{status},#{system},#{size},#{cpu},#{memory},#{brand}";

    @Insert("INSERT INTO " + TABLE_NAME + "(" + PARAMETERS + ") VALUES(" + PARAMETERS_VALUES + ")")
    void insert(Mobile mobile);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id=#{id}")
    void delete(String id);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id=#{id}")
    Mobile select(String id);

    @Select("SELECT DISTINCT ${colName} FROM " + TABLE_NAME)
    List<String> selectDistinctKinds(@org.apache.ibatis.annotations.Param("colName") String colName);

    @Select("SELECT * FROM " + TABLE_NAME + " WHERE brand=#{brand} and system=#{system} and size=#{size}")
    List<Mobile> selectByCondition(String brand,String system,String size);

    @Select("SELECT * FROM " + TABLE_NAME )
    List<Mobile> selectAll();

//        @Select("SELECT * FROM " + TABLE_NAME + " LIMIT #{arg0},#{arg1}")
//        List<Mobile> selectByOffset(int index,int limit);

//        @Update("UPDATE " + TABLE_NAME + " SET name=#{name},password=#{password} WHERE id=#{id}")
//        void update(Mobile mobile);
}