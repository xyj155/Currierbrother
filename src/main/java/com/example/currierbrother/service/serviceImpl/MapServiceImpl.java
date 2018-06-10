package com.example.currierbrother.service.serviceImpl;


import com.example.currierbrother.bean.MapPoint;
import com.example.currierbrother.mapper.MapPointMapper;
import com.example.currierbrother.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MapServiceImpl implements MapService{
    @Autowired
    private MapPointMapper mapMapper=null;


    @Override
    public List<MapPoint> getListMapPoints() {
        return mapMapper.selectMappoints();
    }
}
