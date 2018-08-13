package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Currier;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CurrierMapper {
    int insert(Currier record);

    int insertSelective(Currier record);

    @Select("select * from currier")
    List<Currier> getCurrierList();
}