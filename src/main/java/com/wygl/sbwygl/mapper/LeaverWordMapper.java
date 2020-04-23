package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Leaverword;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface LeaverWordMapper {

    @Select("select * from t_leaverword where type = #{type} limit #{startIndex},#{pagesize}")
    List<Leaverword> queryList(Map map);

    @Select("select count(id) from t_leaverword where type = #{type}")
    Integer querycount(Map map);

    @Delete("delete from t_leaverword where id=#{id}")
    void deleteLeaverword(Integer id);


    @Select("select * from t_leaverword where id=#{id}")
    Leaverword getLeaverWordById(Integer id);

    @Update("update t_leaverword set answerContent=#{answerContent},reDate=#{reDate} where id=#{id}")
    void updateLeaverword(Leaverword leaverword);

    @Select("select * from t_leaverword where userId = #{userId} limit #{startIndex},#{pagesize}")
    List<Leaverword> queryListByUserId(Map map);

    @Select("select count(id) from t_leaverword where userId = #{userId}")
    Integer querycountByUserId(Map map);

    @Insert("insert into t_leaverword(mark,type,leaverName,userId,title,time) " +
            "values(#{mark},#{type},#{leaverName},#{userId},#{title},#{time})")
    void addLeaverWord(Leaverword leaverword);
}
