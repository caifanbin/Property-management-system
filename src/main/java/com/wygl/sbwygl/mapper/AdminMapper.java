package com.wygl.sbwygl.mapper;


import com.wygl.sbwygl.bean.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AdminMapper {

    @Select("select * from admin where AdminName=#{username} and LoginPwd = #{password}")
    public Admin login(String username,String password);

    @Select("select * from admin limit #{startIndex},#{pagesize} ")
    List<Admin> queryList(Map map);

    @Select("select count(id) from admin ")
    Integer querycount(Map map);

    @Insert("insert into admin (loginName,adminName,loginPwd,sex,post,begDate,persionNo)" +
            "values ( #{loginName}, #{adminName},#{loginPwd},#{sex},#{post},#{begDate},#{persionNo})")
    void saveAdmin(Admin admin);

    @Delete("delete from admin where id=#{id}")
    void deleteAdminById(Integer id);

    @Select("select * from admin where id = #{id}")
    Admin getAdminById(Integer id);

    @Update("update admin set AdminName=#{AdminName},LoginName=#{LoginName},LoginPwd=#{LoginPwd}," +
            "persionNo=#{persionNo},post=#{post},sex=#{sex},begDate=#{begDate} where id=#{id}")
    void updateAdmin(Admin admin);
}
