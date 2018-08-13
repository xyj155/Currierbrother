package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.service.serviceImpl.DailyServiceImpl;
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
    private DailyServiceImpl service;

    @RequestMapping("/vrp")
    @ResponseBody
    public void insertResult() {
        int numCities;
        List<Daily> list2 = service.getList();
        int depotX = (int) (Double.parseDouble(list2.get(0).getLatintude()));
        int depotY = (int) (Double.parseDouble(list2.get(0).getLongtitude()));
        numCities = list2.size();
        int[] xCoors = new int[numCities];
        int[] yCoors = new int[numCities];
        int[] demands = new int[numCities];
        int[] windowStarts = new int[numCities];
        int[] windowEnds = new int[numCities];
        int[] serviceTimes = new int[numCities];
        for (int i = 0; i < list2.size(); i++) {
            int x = (int) (Double.parseDouble(list2.get(i).getLatintude()));
            xCoors[i] = x;
            int y = (int) (Double.parseDouble(list2.get(i).getLongtitude()));
            yCoors[i] = (y);
            demands[i] = (1);
            windowStarts[i] = list2.get(i).getServicetime();
            windowEnds[i] = list2.get(i).getEndtime();
            serviceTimes[i] = (10);
        }
        VrpProblem problem = new VrpProblem(demands, xCoors, yCoors, serviceTimes,
                windowStarts, windowEnds, depotX, depotY, 200);
        VrpGreedyInitializer init = new VrpGreedyInitializer(1.0, 1.0, 0);
        VrpSolution sol = init.nearestNeighborHeuristic(problem);
        List<List<Integer>> routes = sol.getRoutes();
        List<List<String>> listVRP = new ArrayList<>();
        for (int j = 0; j < routes.size(); j++) {
            List<Integer> list = routes.get(j);
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list1.add(String.valueOf(list.get(i)));
            }
            listVRP.add(list1);
            System.out.println(list1);
        }
        int numVehicles = sol.getNumVehicles();
        System.out.println(numVehicles);
    }


}
