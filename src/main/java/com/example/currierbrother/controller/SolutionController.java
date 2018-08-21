package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.bean.Solution;
import com.example.currierbrother.service.serviceImpl.DailyServiceImpl;
import com.example.currierbrother.service.serviceImpl.OrderServiceImpl;
import com.example.currierbrother.service.serviceImpl.SolutionServiceImpl;
import com.example.currierbrother.service.serviceImpl.UserServiceImpl;
import com.example.currierbrother.solution.i.VrpGreedyInitializer;

import com.example.currierbrother.solution.problem.VrpProblem;
import com.example.currierbrother.solution.problem.VrpSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/solution")
@Controller
public class SolutionController {
    @Autowired
    private DailyServiceImpl dailyService;
    @Autowired
    SolutionServiceImpl solutionService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping({"/vrp"})
    @ResponseBody
    public Map<String, Object> getPackageList(int userid) {
        Map<String, Object> map = new HashMap();
        Solution solution = solutionService.getSolution(userid);
        if (solution==null){
            List<Daily> list=new ArrayList<>();
            map.put("code", 201);
            map.put("success", false);
            map.put("msg", "获取数据失败！");
            map.put("data", list);
        }else {
            String packages = solution.getPackages();
            String replace = packages.replace("[", " ").replace("]", "");
            String[] split = replace.split(",");
            List<Daily> list = new ArrayList<>();
            for (String aSplit : split) {
                if (!(orderService.getExpressByUid(Integer.valueOf(aSplit.trim()))==null)){
                    list.add(orderService.getExpressByUid(Integer.valueOf(aSplit.trim())));
                }
            }
            if (list.size()>0){
                map.put("code", 200);
                map.put("success", true);
                map.put("msg", "获取数据成功！");
                map.put("data", list);
            }else {
                map.put("code", 201);
                map.put("success", false);
                map.put("msg", "获取数据失败！");
                map.put("data", list);
            }
        }
        return map;
    }


}
