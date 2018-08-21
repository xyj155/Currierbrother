package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.OrderHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderHistoryMapper {
    int deleteByPrimaryKey(Integer id);
    @Insert({"INSERT INTO orderhistory " +
            "(uid,pid) " +
            "VALUES " +
            "(#{uid},#{pid})"})
    int insert(OrderHistory record);

    int insertSelective(OrderHistory record);

    OrderHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderHistory record);

    int updateByPrimaryKey(OrderHistory record);

    @Select("select * from orderhistory where year(time)=year(now()) and month(time)=month(now()) and day(time)=day(now())")
    List<OrderHistory> getTodayAllHistory();
}