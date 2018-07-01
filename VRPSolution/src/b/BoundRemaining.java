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

package b;

/**
 * Computes a bound on the cost of inserting the remaining uninserted nodes.
 */
public class BoundRemaining {
  
  private double[] minInsertionCosts;
  private double bound;
  
  public BoundRemaining(int numCusts) {
    minInsertionCosts = new double[numCusts];
  }
  
  public void updateMinInsertionCost(int custId, double minCost) {
    bound = bound - minInsertionCosts[custId] + minCost;
    minInsertionCosts[custId] = minCost;
  }
  
  public void notifyCustInserted(int custId) {
    bound -= minInsertionCosts[custId];
  }
  
  public void notifyCustReverted(int custId) {
    bound += minInsertionCosts[custId];
  }
  
  public double getBound() {
    return bound;
  }
}
