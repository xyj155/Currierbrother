package com.example.currierbrother.controller;


import com.example.currierbrother.bean.UserScan;
import com.example.currierbrother.service.serviceImpl.UserScanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userscan")
public class UserScanController {
    @Autowired
    private UserScanServiceImpl scan;

    @RequestMapping("/list")
    @ResponseBody
    public List<UserScan> getList() {
        List<UserScan> allList = scan.getAllList();
        return allList;
    }
}
