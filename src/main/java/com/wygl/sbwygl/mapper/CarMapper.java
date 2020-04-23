package com.wygl.sbwygl.mapper;

import com.wygl.sbwygl.bean.CarNum;
import com.wygl.sbwygl.bean.CarOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface CarMapper {

    @Select("select * from carnum limit #{startIndex},#{pagesize}")
    List<CarNum> queryCarNum(Map map);

    @Select("select count(id) from carnum")
    Integer queryCarNumcount(Map map);

    @Select("select * from carorder limit #{startIndex},#{pagesize}")
    List<CarOrder> queryCarOrder(Map map);

    @Select("select count(id) from carorder")
    Integer queryCarOrdercount(Map map);

    @Insert("insert into carorder(username,state,address,telephone,persionNo,carAddress,userid,changedate,carimage)" +
            "values(#{username},#{state},#{address},#{telephone},#{persionNo},#{carAddress},#{userid},#{changedate},#{carimage})")
    void saveCarOrder(CarOrder carOrder);

    @Select("select * from carorder where id=#{id}")
    CarOrder getCarOrderById(Integer id);

    @Update("update carorder set state=#{state} where id=#{id}")
    void updateCarOrder(CarOrder carOrder);

    @Delete("delete from carorder where id=#{id}")
    void deleteCarOrder(Integer id);

    @Select("select * from carorder where userid=#{userid} limit #{startIndex},#{pagesize}")
    List<CarOrder> getChangeByUserid(Map map);

    @Select("select count(id) from carorder where userid=#{userid}")
    Integer queryChangecountbyUserid(Map map);
}
