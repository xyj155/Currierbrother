package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Currier;
import com.example.currierbrother.service.CurrierService;
import com.example.currierbrother.service.serviceImpl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("currier")
@Controller
public class CurrierController {
    @Autowired
    private CurrierService carService;

    @RequestMapping("list")
    @ResponseBody
    public List<Currier> getAllList() {
        return carService.getCurrierList();
    }
}
