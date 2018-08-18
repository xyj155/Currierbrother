package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Express;
import com.example.currierbrother.bean.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Delete("DELETE FROM userscan WHERE id=#{id}")
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    @Select("select *  FROM userscan WHERE id=#{id}")
    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select * from userscan where year(createtime)=year(now()) and month(createtime)=month(now()) and day(createtime)=day(now())")
    List<Express> getDailyPackage();
}