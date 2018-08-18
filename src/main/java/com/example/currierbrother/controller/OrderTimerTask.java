//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.bean.Express;
import com.example.currierbrother.bean.Solution;
import com.example.currierbrother.bean.User;
import com.example.currierbrother.service.serviceImpl.DailyServiceImpl;
import com.example.currierbrother.service.serviceImpl.OrderServiceImpl;
import com.example.currierbrother.service.serviceImpl.SolutionServiceImpl;
import com.example.currierbrother.service.serviceImpl.UserServiceImpl;
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

    public OrderTimerTask() {
    }

    /**
     * 定时插入当天所有的订单
     */
    @Scheduled(
            cron = "0/5 * * * * ?"
    )
    public void insertDailyOrderScheduler() {
       dailyService.deletAll();
        List<Express> dailyPackage = this.orderService.getDailyPackage();
        if (dailyPackage.size()>0){
            int index = 300;
            for (int i = 0; i < dailyPackage.size(); ++i) {
                Daily daily = new Daily();
                System.out.println(dailyPackage.get(i).getLongitude());
                System.out.println(dailyPackage.get(i).getLatitude());
                daily.setServicetime(index + i * 5 + 1);
                daily.setEndtime(index + (i + 1) * 5);
                daily.setLatintude(((Express) dailyPackage.get(i)).getLatitude());
                daily.setLongtitude(((Express) dailyPackage.get(i)).getLongitude());
                daily.setEndlocaton(((Express) dailyPackage.get(i)).getEndlocation());
                daily.setStartlocation(((Express) dailyPackage.get(i)).getStartlocation());
                daily.setOrdernum(((Express) dailyPackage.get(i)).getOrdernum());
                daily.setUid(Integer.valueOf(((Express) dailyPackage.get(i)).getUserid()));
                daily.setUsername(((Express) dailyPackage.get(i)).getUsername());
                daily.setTel(((Express) dailyPackage.get(i)).getUsertel());
                this.dailyService.insertDaily(daily);
            }
        }
    }

    @Scheduled(
            cron = "0/5 * * * * ?"
    )
    /**
     * 对当天的所有订单进行路径规划
     */
    public void SolutionScheduler() {
        this.solutionService.deletAll();
        List<Daily> list2 = this.dailyService.getList();
        if (list2.size()>0){
            int depotX = (int) ((Daily) list2.get(0)).getLatintude();
            int depotY = (int) ((Daily) list2.get(0)).getLongtitude();
            int numCities = list2.size();
            int[] xCoors = new int[numCities];
            int[] yCoors = new int[numCities];
            int[] demands = new int[numCities];
            int[] windowStarts = new int[numCities];
            int[] windowEnds = new int[numCities];
            int[] serviceTimes = new int[numCities];

            for (int i = 0; i < list2.size(); ++i) {
                int x = (int) ((Daily) list2.get(i)).getLatintude();
                xCoors[i] = x;
                int y = (int) ((Daily) list2.get(i)).getLongtitude();
                yCoors[i] = y;
                demands[i] = 1;
                windowStarts[i] = Integer.valueOf(((Daily) list2.get(i)).getServicetime());
                windowEnds[i] = Integer.valueOf(((Daily) list2.get(i)).getEndtime());
                serviceTimes[i] = 10;
            }

            VrpProblem problem = new VrpProblem(demands, xCoors, yCoors, serviceTimes, windowStarts, windowEnds, depotX, depotY, 200);
            VrpGreedyInitializer init = new VrpGreedyInitializer(1.0D, 1.0D, 0.0D);
            VrpSolution sol = init.nearestNeighborHeuristic(problem);
            List<List<Integer>> routes = sol.getRoutes();
            List<User> userList = this.userService.getUserList();

            for (int j = 0; j < routes.size(); j++) {
                System.out.println(j);
                List<Integer> list = (List) routes.get(j);
                List<String> list1 = new ArrayList();
                Solution solution = new Solution();
                System.out.println(list);
                for (int i = 0; i < list.size(); ++i) {
                    list1.add(String.valueOf((Integer) list.get(i)));
                }
                Integer id = ((User) userList.get(j)).getId();
                solution.setPackages(list1.toString());
                System.out.println(id);
                solution.setUserid(String.valueOf(id));
                this.solutionService.insertSolution(solution);
            }

        }

    }



}
