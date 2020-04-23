package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Resident;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ResidentMapper {
    @Select("select * from resident where username=#{username} and password = #{password}")
     Resident login(String username,String password);

    @Insert("insert into resident (username,password,persionNo,sex,telephone,address,type,date)" +
            "values ( #{username}, #{password},#{persionNo},#{sex},#{telephone},#{address},#{type},#{date})")
    void saveResident(Resident resident);



    @Select("select * from resident limit #{startIndex},#{pagesize} ")
    List<Resident> queryList(Map map);

    @Select("select count(id) from resident ")
    Integer querycount(Map map);

    @Select("select * from resident")
    List<Resident> getResidentAll();

    @Select("select * from resident where id=#{id}")
    Resident getResidentById(Integer id);

    @Update("update resident set username=#{username},password=#{password}," +
            "persionNo=#{persionNo},sex=#{sex},telephone=#{telephone}," +
            "address=#{address},date=#{date} where id=#{id} ")
    int updateResident(Resident resident);


    @Delete("delete from resident where id=#{id}")
    int deleteResidentById(Integer id);
}
