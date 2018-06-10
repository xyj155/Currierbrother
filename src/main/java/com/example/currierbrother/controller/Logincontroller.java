package com.example.currierbrother.controller;

import com.example.currierbrother.bean.CMap;
import com.example.currierbrother.service.serviceImpl.MapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class Logincontroller {
    @Autowired
    private MapServiceImpl sqlMapMapper;

    @RequestMapping("/index")
    public ModelAndView loginIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

//
//    @RequestMapping(value = "/users")
//    @ResponseBody
//    public CMap getUserList() {
////        java.util.Map<Object, Object> map = new HashMap<>();
////        SQLMap users = sqlMapMapper.selectByPrimaryKey(1);
////        map.put("msg", users);
//        return sqlMapMapper.getListMapPoints();
//    }


}
