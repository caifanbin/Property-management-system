package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Ba;
import com.wygl.sbwygl.bean.Pb;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface BaMapper {

    @Select("select * from ba limit #{startIndex},#{pagesize} ")
    List<Ba> queryList(Map map);

    @Select("select count(id) from ba ")
    Integer querycount(Map map);

    @Insert("insert into ba (name,sex,post,begDate,persionNo)values ( #{name},#{sex},#{post},#{begDate},#{persionNo})")
    void saveBa(Ba ba);

    @Select("select * from pb limit #{startIndex},#{pagesize} ")
    List<Pb> queryPbList(Map map);

    @Select("select count(id) from pb ")
    Integer queryPbcount(Map map);

    @Insert("insert into pb(name,startTime,endTime) values(#{name},#{startTime},#{endTime})")
    void saveBapb(Pb pb);

    @Delete(("delete from ba where id=#{id}"))
    void deleteBaById(Integer id);

    @Select("select * from ba where id = #{id}")
    Ba getBaById(Integer id);

    @Update("update ba set name=#{name},persionNo=#{persionNo},post=#{post},sex=#{sex}" +
            ",begDate=#{begDate} where id= #{id}")
    void updateBa(Ba ba);

    @Select("select * from pb where id=#{id}")
    Pb getBapbById(Integer id);

    @Delete("delete from pb where id=#{id}")
    void deleteBapbById(Integer id);

    @Update("update pb set name=#{name},startTime=#{startTime},endTime=#{endTime} where id=#{id}")
    void updateBapb(Pb pb);
}
