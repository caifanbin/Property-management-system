package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Chanel;
import com.wygl.sbwygl.bean.Rs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ChanelMapper {

    @Insert("insert into chanel (name,num,model,beDate,mark,inName)values ( #{name},#{num},#{model},#{beDate},#{mark},#{inName})")
    void saveChanel(Chanel chanel);

    @Select("select * from chanel limit #{startIndex},#{pagesize} ")
    List<Chanel> queryRsList(Map map);

    @Select("select count(id) from chanel ")
    Integer queryRscount(Map map);

    @Delete("delete from chanel where id = #{id}")
    void deleteChanelById(Integer id);

    @Update("update chanel set name=#{name},model=#{model}," +
            "num=#{num},beDate=#{beDate},mark=#{mark} where id=#{id}")
    void updateChanel(Chanel chanel);

    @Select("select * from chanel where id = #{id}")
    Chanel getChanelById(Integer id);
}
