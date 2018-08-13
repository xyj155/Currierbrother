package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Express;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExpressMapper {
//    @Select("select * from ")
    List<Express> getAllStation();
}
