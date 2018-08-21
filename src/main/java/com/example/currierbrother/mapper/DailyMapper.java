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
    int deleteByPrimaryKey(Integer var1);

    @Insert({"INSERT INTO dailyorder (ordernum,latintude,longtitude,username,startlocation,endlocation,tel,servicetime,endtime,pid) VALUES (#{ordernum},#{latintude},#{longtitude},#{username},#{startlocation},#{endlocation},#{tel},#{servicetime},#{endtime},#{pid})"})
    int insert(Daily var1);

    int insertSelective(Daily var1);

    @Select({"select * FROM dailyorder WHERE id=#{id}"})
    Daily selectByPrimaryKey(Integer var1);

    int updateByPrimaryKeySelective(Daily var1);

    int updateByPrimaryKey(Daily var1);

    @Select({"select * from dailyorder"})
    List<Daily> getList();

    @Select("select * from dailyorder where id = #{id}")
    Daily getExpressById(int var1);

    @Delete({"truncate table dailyorder;"})
    void deletAll();
}
