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

package com.example.currierbrother.solution.i;


import com.example.currierbrother.solution.problem.VrpProblem;
import com.example.currierbrother.solution.problem.VrpSolution;

import java.util.*;

public class VrpGreedyInitializer {
  private static final double TIME_DIFF_WEIGHT = .4;
  private static final double DISTANCE_WEIGHT = .4;
  private static final double URGENCY_WEIGHT = .2;
  
  private double timeDiffWeight = TIME_DIFF_WEIGHT;
  private double distanceWeight = DISTANCE_WEIGHT;
  private double urgencyWeight = URGENCY_WEIGHT;
  
  public VrpGreedyInitializer(double timeDiffWeight, double distanceWeight, double urgencyWeight) {
    this.timeDiffWeight = timeDiffWeight;
    this.distanceWeight = distanceWeight;
    this.urgencyWeight = urgencyWeight;
  }
  
  public VrpSolution nearestNeighborHeuristic(VrpProblem problem) {
    return nearestNeighborHeuristic(problem, new ArrayList<List<Integer>>());
  }
  
  /**
   * 所罗门文件中的最近邻启发式算法
   */
  public VrpSolution nearestNeighborHeuristic(VrpProblem problem, List<List<Integer>> routes) {
    Set<Integer> remainingNodes = new HashSet<Integer>();
    for (int i = 0; i < problem.getNumCities(); i++) {
      remainingNodes.add(i);
    }
    for (List<Integer> route : routes) {
      for (Integer node : route) {
        remainingNodes.remove(node);
      }
    }
    
    List<Integer> curRoute = new ArrayList<Integer>();
    routes.add(curRoute);
    int curNodeId = -1;
    double curVisitTime = 0;
    int remCapacity = problem.getVehicleCapacity();
    while (remainingNodes.size() > 0) {
      Number[] ret = findClosest(curNodeId, curVisitTime, remCapacity, remainingNodes, problem);
      int nextNodeId = (Integer)ret[0];
      if (nextNodeId != -1) {
        remainingNodes.remove(nextNodeId);
        curRoute.add(nextNodeId);
        curNodeId = nextNodeId;
        curVisitTime = (Double)ret[1];
        remCapacity -= problem.getDemands()[nextNodeId];
      } else {
        curRoute = new ArrayList<Integer>();
        routes.add(curRoute);
        curVisitTime = 0;
        curNodeId = -1;
        remCapacity = problem.getVehicleCapacity();
      }
    }
    
    return new VrpSolution(routes, problem);
  }

  /***
   * 获取最近的两个节点
   * @param curLastId
   * @param curLastVisitTime
   * @param remCapacity
   * @param remainingNodes
   * @param problem
   * @return
   */
  private Number[] findClosest(int curLastId, double curLastVisitTime, int remCapacity,
      Set<Integer> remainingNodes, VrpProblem problem) {
    
    int[] demands = problem.getDemands();
    int[] windowStartTimes = problem.getWindowStartTimes();
    int[] windowEndTimes = problem.getWindowEndTimes();
    double[][] distances = problem.getDistances();
    double[] distancesFromDepot = problem.getDistancesFromDepot();
    int[] serviceTimes = problem.getServiceTimes();
    int curLastServiceTime = (curLastId == -1) ? 0 : serviceTimes[curLastId];
    
    double bestVal = Integer.MAX_VALUE;
    int bestNodeId = -1;
    double bestNodeVisitTime = -1;
    
    //bj = time when service begins, for depot its 0
    Iterator<Integer> iter = remainingNodes.iterator();
    while (iter.hasNext()) {
      int nodeId = iter.next();
      if (demands[nodeId] > remCapacity) {
        continue;
      }
      
      double distance = (curLastId == -1) ? distancesFromDepot[nodeId] : distances[curLastId][nodeId];
      double minVisitTime = Math.max(windowStartTimes[nodeId], curLastVisitTime + curLastServiceTime + distance);
      if (minVisitTime > windowEndTimes[nodeId]) {
        continue;
      }
      double timeDiff = minVisitTime - (curLastVisitTime + curLastServiceTime);
      double urgency = windowEndTimes[nodeId] - (curLastVisitTime + curLastServiceTime + distance);
      double val = timeDiff * timeDiffWeight + distance * distanceWeight + urgency * urgencyWeight;
      if (val < bestVal) {
        bestVal = val;
        bestNodeId = nodeId;
        bestNodeVisitTime = minVisitTime;
      }
    }
    
    return new Number[] {new Integer(bestNodeId), new Double(bestNodeVisitTime)};
  }
}
