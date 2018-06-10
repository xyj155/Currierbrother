package com.example.currierbrother.controller;


import com.example.currierbrother.bean.MapPoint;
import com.example.currierbrother.service.serviceImpl.MapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/map")
public class MapController {
    @Autowired
    private MapServiceImpl service;

    @RequestMapping("/list")
    @ResponseBody
    public List<MapPoint> getList() {
        return service.getListMapPoints();
    }
}
