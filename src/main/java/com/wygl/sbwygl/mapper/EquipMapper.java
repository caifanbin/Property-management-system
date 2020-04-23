package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Equip;
import com.wygl.sbwygl.bean.Pb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface EquipMapper {

    @Select("select * from equip limit #{startIndex},#{pagesize} ")
    List<Equip> queryList(Map map);

    @Select("select count(id) from equip ")
    Integer querycount(Map map);

    @Insert("insert into equip(name,inName,mark,tel,revalue,address,beDate)" +
            " values(#{name},#{inName},#{mark},#{tel},#{revalue},#{address},#{beDate})")
    void saveEquip(Equip equip);

    @Delete("delete from equip where id=#{id}")
    void deleteEquip(Integer id);

    @Select("select * from equip where id = #{id}")
    Equip getEquipById(Integer id);

    @Update("update equip set name=#{name},inName=#{inName},mark=#{mark},tel=#{tel}," +
            "revalue=#{revalue},address=#{address},beDate=#{beDate} where id=#{id}")
    void updateEquip(Equip equip);

    @Select("select * from equip where inName=#{inName} limit #{startIndex},#{pagesize}")
    List<Equip> getChangeByinName(Map map);

    @Select("select count(id) from equip where inName=#{inName}")
    Integer queryChangecountbyinName(Map map);
}
