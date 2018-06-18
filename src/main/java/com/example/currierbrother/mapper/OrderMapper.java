package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Order;
import org.apache.ibatis.annotations.Delete;

public interface OrderMapper {
    @Delete("DELETE FROM userscan WHERE id=#{id}")
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}