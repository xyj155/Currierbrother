/**
 * Copyright 2012 Sandy Ryza
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.currierbrother.solution.problem;

import java.util.Iterator;
import java.util.List;

/**
 * Represents a solution or partial solution to the vehicle routing problem.
 */
public class VrpSolution {
  //values of -1 point to the depot
  private List<List<Integer>> routes;
  private List<Integer> unrouted;
  private int numVehicles;
  private VrpProblem problem;
  private double toursCost = -1;
  
  public VrpSolution(List<List<Integer>> routes, VrpProblem problem) {
    this.routes = routes;
    this.problem = problem;
    this.numVehicles = routes.size();
  }
  


  
  public VrpProblem getProblem() {
    return problem;
  }
  
  public List<List<Integer>> getRoutes() {
    return routes;
  }
  
  public List<Integer> getUninsertedNodes() {
    return unrouted;
  }
  
  public int getNumVehicles() {
    return numVehicles;
  }
  
  /**
   * Verify that the solution satisfied the constraints for the given problem,
   * and that the reported values for the objective function are correct.
   */
  public boolean verify(VrpProblem problem) {
    double[][] distances = problem.getDistances();
    double[] distancesFromDepot = problem.getDistancesFromDepot();
    int[] windowStartTimes = problem.getWindowStartTimes();
    int[] windowEndTimes = problem.getWindowEndTimes();
    int[] serviceTimes = problem.getServiceTimes();
    int[] demands = problem.getDemands();
    boolean[] visited = new boolean[problem.getNumCities()];
    for (List<Integer> route : routes) {
      System.out.println(route);
      Iterator<Integer> iter = route.iterator();
      if (route.isEmpty()) {
        System.out.println("无路程!!!");
        continue;
      }
      int prev = iter.next();
      if (windowEndTimes[prev] < distancesFromDepot[prev]) {
        System.out.println("第一节点违反时间约束: 结束时间=" +
            windowEndTimes[prev] + ", 距离=" + distancesFromDepot[prev]);
        return false;
      }
      visited[prev] = true;
      int remCapacity = problem.getVehicleCapacity() - demands[prev];//如果货车容量低于快递容量
      double minVisitTime = Math.max(windowStartTimes[prev], distancesFromDepot[prev]);//计算最短的访问时间

      while (iter.hasNext()) {
        int cur = iter.next();
        visited[cur] = true;
        double nextMinVisitTime = Math.max(minVisitTime + serviceTimes[prev] + distances[prev][cur], windowStartTimes[cur]);
        if (nextMinVisitTime > windowEndTimes[cur]) {//假如下一个节点 访问时间大于前一个节点的结束时间
          System.out.println(minVisitTime + "\t" + serviceTimes[prev] + "\t" + distances[prev][cur]);
          System.out.println("违反时间约束 " + prev + "->" + cur +
              ": 结束时间=" + windowEndTimes[cur] + ", 访问时间=" + nextMinVisitTime);
          return false;
        }
        minVisitTime = nextMinVisitTime;
        
        remCapacity -= demands[cur];
        if (remCapacity < 0) {
          System.out.println("违反容量限制");
          return false;
        }
        prev = cur;
      }
    }  
    
    for (boolean b : visited) {
      if (!b) {
        System.out.println("未访问的节点之一");
        return false;
      }
    }

    
    return true;
  }
}
