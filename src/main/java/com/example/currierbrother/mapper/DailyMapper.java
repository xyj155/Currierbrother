package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Daily;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DailyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Daily record);

    int insertSelective(Daily record);

    Daily selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Daily record);

    int updateByPrimaryKey(Daily record);
    @Select("select * from dailyorder")
    List<Daily> getList();
}