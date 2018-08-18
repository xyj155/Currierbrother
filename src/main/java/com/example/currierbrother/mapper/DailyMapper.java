//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Daily;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    @Insert({"INSERT INTO dailyorder (ordernum,latintude,longtitude,username,startlocation,endlocaton,tel,uid,servicetime,endtime) VALUES (#{ordernum},#{latintude},#{longtitude},#{username},#{startlocation},#{endlocaton},#{tel},#{uid},#{servicetime},#{endtime})"})
    int insert(Daily record);

    int insertSelective(Daily record);

    Daily selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Daily record);

    int updateByPrimaryKey(Daily record);

    @Select({"select * from dailyorder"})
    List<Daily> getList();

    @Select({"select * from dailyorder where id =#{id}"})
    Daily getExpressByUid(int id);

    @Delete({"truncate table dailyorder;"})
    void deletAll();
}
