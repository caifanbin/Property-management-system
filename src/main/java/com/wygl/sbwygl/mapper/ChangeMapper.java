package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Change;
import com.wygl.sbwygl.bean.Rs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface ChangeMapper {

    @Insert("insert into t_change (dNo,zName,type,changeName,remark,waterCase,eCase,gascase,stopCase,mandCase,cases,userid,changedate) " +
            "values ( #{dNo},#{zName},#{type},#{changeName},#{remark},#{waterCase},#{eCase},#{gascase},#{stopCase},#{mandCase},#{cases},#{userid},#{changedate})")
    void saveChange(Change change);

    @Select("select * from t_change limit #{startIndex},#{pagesize} ")
    List<Change> queryChangeList(Map map);

    @Select("select count(id) from t_change ")
    Integer queryChangecount(Map map);

    @Select("select * from t_change where id=#{id}")
    Change getChangeById(Integer id);

    @Update("update t_change set dNo=#{dNo},zName=#{zName},type=#{type},changeName=#{changeName},remark=#{remark},waterCase=#{waterCase},eCase=#{eCase}," +
            "gascase=#{gascase},stopCase=#{stopCase},mandCase=#{mandCase},cases=#{cases},userid=#{userid},changedate=#{changedate} where id=#{id}")
    void updateChange(Change change);

    @Delete("delete from t_change where id=#{id}")
    void deleteChange(Integer id);

    @Select("select * from t_change where zName = #{zName} limit #{startIndex},#{pagesize}  ")
    List<Change> getChangeByZname(Map map);

    @Select("select count(id) from t_change where zName=#{zName}")
    Integer queryChangecountbyzName(Map map);
}
