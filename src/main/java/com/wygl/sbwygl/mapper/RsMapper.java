package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.Rs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface RsMapper {

    @Select("select count(id) from rs ")
    Integer queryRscount(Map map);
    @Select("select * from rs limit #{startIndex},#{pagesize} ")
    List<Rs> queryRsList(Map map);

    @Insert("insert into rs (adminName,sex,loginName,loginPwd,post,begDate,persionNo)values ( #{adminName},#{sex},#{loginName},#{loginPwd},#{post},#{begDate},#{persionNo})")
    void saveRs(Rs rs);

    @Delete("delete from rs where id=#{id}")
    void deleteRs(Integer id);

    @Select("select * from rs where id=#{id}")
    Rs getRsById(Integer id);

    @Update("update rs set adminName=#{adminName},loginName=#{loginName},loginPwd=#{loginPwd}," +
            "persionNo=#{persionNo},sex=#{sex},begDate=#{begDate},post=#{post} where id=#{id}")
    void updateRs(Rs rs);
}
