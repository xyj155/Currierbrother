package com.example.currierbrother.controller;


import com.example.currierbrother.bean.Express;
import com.example.currierbrother.service.serviceImpl.ExpressStationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/expressstation")
public class ExpressController {
    @Autowired
    private ExpressStationServiceImpl expressStationService;

    @RequestMapping("/all")
    @ResponseBody
    public List<Express> getAllList() {
        List<Express> expressAllList = expressStationService.getExpressAllList();
        return expressAllList;

    }
}
