//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.currierbrother.controller;

import com.example.currierbrother.bean.*;
import com.example.currierbrother.service.serviceImpl.*;
import com.example.currierbrother.solution.i.VrpGreedyInitializer;
import com.example.currierbrother.solution.problem.VrpProblem;
import com.example.currierbrother.solution.problem.VrpSolution;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class OrderTimerTask {

    @Autowired
    private DailyServiceImpl dailyService;
    @Autowired
    SolutionServiceImpl solutionService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    UserScanServiceImpl userScanService;
    @Autowired
    HistoryServiceImpl historyService;

    public OrderTimerTask() {
    }

    /**
     * 定时插入当天所有的订单
     */
    @Scheduled(
            cron = "0 15 7 * * ?"
    )
    public void insertDailyOrderScheduler() {
        dailyService.deletAll();
        List<Express> expresses = orderService.getDailyPackage();//获取路径规划方案
        if (expresses.size() > 0) {
            int index = 300;
            for (int i = 0; i < expresses.size(); i++) {
                List<Express> dailyPackage = orderService.getDailyPackage();
                Daily daily = new Daily();
                daily.setServicetime(index + i * 5 + 1);
                daily.setEndtime(index + (i + 1) * 5);
                System.out.println(dailyPackage.get(i).getId());
                daily.setPid(String.valueOf(dailyPackage.get(i).getId()));
                daily.setLatintude(dailyPackage.get(i).getLatitude());
                daily.setLongtitude(dailyPackage.get(i).getLongitude());
                daily.setEndlocation(dailyPackage.get(i).getEndlocation());
                daily.setStartlocation(dailyPackage.get(i).getStartlocation());
                daily.setOrdernum(dailyPackage.get(i).getOrdernum());
                daily.setUsername(dailyPackage.get(i).getUsername());
                daily.setTel(dailyPackage.get(i).getUsertel());
                this.dailyService.insertDaily(daily);
            }
        }
    }

    @Scheduled(
            cron = "0 15 7 * * ?"
    )
    /**
     * 对当天的所有订单进行路径规划
     */
    public void SolutionScheduler() {
        this.solutionService.deletAll();
        List<Daily> list2 = this.dailyService.getList();//获取当天所有的订单
        if (list2.size() > 0) {
            int depotX = (int) (list2.get(0).getLatintude());
            int depotY = (int) (list2.get(0).getLongtitude());
            int numCities = list2.size();
            int[] xCoors = new int[numCities];
            int[] yCoors = new int[numCities];
            int[] demands = new int[numCities];
            int[] windowStarts = new int[numCities];
            int[] windowEnds = new int[numCities];
            int[] serviceTimes = new int[numCities];
            for (int i = 0; i < list2.size(); ++i) {
                int x = (int) (list2.get(i).getLatintude());
                xCoors[i] = x;
                int y = (int) (list2.get(i).getLongtitude());
                yCoors[i] = y;
                demands[i] = 1;
                windowStarts[i] = Integer.valueOf((list2.get(i).getServicetime()));
                windowEnds[i] = Integer.valueOf(((Daily) list2.get(i)).getEndtime());
                serviceTimes[i] = 10;
            }
            VrpProblem problem = new VrpProblem(demands, xCoors, yCoors, serviceTimes, windowStarts, windowEnds, depotX, depotY, 200);
            VrpGreedyInitializer init = new VrpGreedyInitializer(1.0D, 1.0D, 0.0D);
            VrpSolution sol = init.nearestNeighborHeuristic(problem);
            List<List<Integer>> routes = sol.getRoutes();//规划方案
            List<User> userList = this.userService.getUserList();
            //routes.size() 方案数
            for (int j = 0; j < routes.size(); j++) {
                List<Integer> routerlist = (List) routes.get(j);
                List<String> packagelist = new ArrayList();
                Solution solution = new Solution();
                System.out.println(routerlist);
                for (int i = 0; i < routerlist.size(); ++i) {
                    packagelist.add(String.valueOf((Integer) routerlist.get(i) + 1));
                }
                Integer id = ((User) userList.get(j)).getId();
                solution.setPackages(packagelist.toString());
                solution.setUserid(String.valueOf(id));
                this.solutionService.insertSolution(solution);
            }
        }
    }

    @Scheduled(
            cron = "0 15 22 * * ?"
    )
    public void insertDeliverHistory() {
        List<OrderHistory> allHistory = historyService.getTodayAllHistory();
        if (allHistory.size() == 0) {
            List<Solution> solutionList = solutionService.getSolutionList();
            if (solutionList.size() > 0) {
                for (int i = 0; i < solutionList.size(); i++) {
                    String packages = solutionList.get(i).getPackages();
                    String replace = packages.replace("[", "").replace("]", "");
                    String[] split = replace.split(",");
                    for (int k = 0; k < split.length; k++) {
                        System.out.println(split[k].trim() + "---------");
                        Daily dailyOrderById = dailyService.getDailyOrderById(Integer.valueOf(split[k].trim()));
                        System.out.println(dailyOrderById);
                        OrderHistory history = new OrderHistory();
                        System.out.println(dailyOrderById);
                        history.setPid(dailyOrderById.getPid());
                        history.setUid(Integer.valueOf(solutionList.get(i).getUserid()));
                        historyService.insert(history);
                    }
                }
            }
        }
    }
}
