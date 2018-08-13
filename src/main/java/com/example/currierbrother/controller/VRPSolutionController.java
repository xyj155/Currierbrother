package com.example.currierbrother.controller;


import com.example.currierbrother.bean.VRP;
import com.example.currierbrother.solution.i.VrpGreedyInitializer;
import com.example.currierbrother.solution.i.VrpReader;
import com.example.currierbrother.solution.problem.VrpProblem;
import com.example.currierbrother.solution.problem.VrpSolution;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/vrpsolution")
public class VRPSolutionController {

    @RequestMapping("/vrp")
    @ResponseBody
    public Map<String, Object> solutionVRP() throws IOException {
        File f = new File("D:\\IdeaProjects\\Currierbrother\\src\\main\\java\\com\\example\\currierbrother\\rc110_1.txt");
        VrpProblem problem = VrpReader.readSolomon(f, 100);
        // seems like more for the first two and less for the last works
        VrpGreedyInitializer init = new VrpGreedyInitializer(1.0, 1.0, 0);
        VrpSolution sol = init.nearestNeighborHeuristic(problem);
        List<List<Integer>> routes = sol.getRoutes();
        Map<String, Object> map = new HashMap<>();
        List<List<String>> listVRP = new ArrayList<>();
        for (int j = 0; j < routes.size(); j++) {
            List<Integer> list = routes.get(j);
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                list1.add(String.valueOf(list.get(i)));
            }
            listVRP.add(list1);
        }
        map.put("success", "true");
        map.put("code", "200");
        map.put("data", listVRP);
        return map;
    }


    @RequestMapping("/gson")
    @ResponseBody
    public String Gson() {
        String s = sendGet("http://localhost:8080/vrpsolution/vrp", null, "utf-8");
        Gson gson = new Gson();
        VRP vrp = gson.fromJson(s, VRP.class);
        List<List<String>> data = vrp.getData();
        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
            for (int j = 0; j < data.get(i).size(); j++) {
                System.out.println(data.get(i).get(j));
            }
        }
        return " ";
    }

    public static String sendGet(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;
        // 构建请求参数
        StringBuffer sbParams = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        HttpURLConnection con = null;
        BufferedReader br = null;
        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            resultBuffer = new StringBuffer();
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
            String temp;
            while ((temp = br.readLine()) != null) {
                resultBuffer.append(temp);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
        return resultBuffer.toString();
    }

}
