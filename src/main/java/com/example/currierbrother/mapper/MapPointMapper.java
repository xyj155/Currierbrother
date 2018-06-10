package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.MapPoint;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapPointMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapPoint record);

    int insertSelective(MapPoint record);

    MapPoint selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapPoint record);

    int updateByPrimaryKey(MapPoint record);
    @Select("select * from map")
    List<MapPoint> selectMappoints();
}