package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Car;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarMapper {
    @Select("select * from car")
    List<Car> carlist();
}
