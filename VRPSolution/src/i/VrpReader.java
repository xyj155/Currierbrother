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

package i;



import problem.VrpProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads vehicle routing problems in the Solomon format from input files
 */
public class VrpReader {
  public static VrpProblem readSolomon(File f, int numCities) throws IOException {
    //获取数据信息和城市数量
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line = br.readLine();
      System.out.println(line+"\n第一行");
   //trim（）方法:去除左右边的空格

    int capacity = Integer.parseInt(line.trim());
    /**
     * 单行读取文件
     */
    line = br.readLine();
      System.out.println(line+"\n第二行");
    String[] tokens = line.trim().split("\\s+");
    /**
     * 获取列单元
     * tokens[1]为X轴的值
     * tokens[2]为Y轴的值
     */
    int depotX = (int)(Double.parseDouble(tokens[1]));//出发点X值
    int depotY = (int)(Double.parseDouble(tokens[2]));//出发点Y值

    /**输出tokens的值
     * tokens:0250250001821023
     * depostX=255
     * depostY=255
     */
    List<String> lines = new ArrayList<String>();
    for (int i = 0; i < numCities && (line = br.readLine()) != null; i++) {
      /**
       * 将全部的数据装载到List<>集合
       */
      lines.add(line);
    }
    
    numCities = lines.size();//城市数量
      System.out.println(numCities+"\n");
    int[] xCoors = new int[numCities];//X轴的值
    int[] yCoors = new int[numCities];//Y轴的值
    int[] demands = new int[numCities];//派送物品数量
    int[] windowStarts = new int[numCities];//准备时间
    int[] windowEnds = new int[numCities];//花费的时间
    int[] serviceTimes = new int[numCities];//服务时间

    for (int i = 0; i < numCities; i++) {
      tokens = lines.get(i).trim().split("\\s+");

      //CUST NO.   XCOORD.   YCOORD.    DEMAND   READY TIME   DUE DATE   SERVICE TIME
      int x = (int)(Double.parseDouble(tokens[1]));
      xCoors[i] = (x);
      int y = (int)(Double.parseDouble(tokens[2]));
      yCoors[i] = (y);
      int demand = (int)(Double.parseDouble(tokens[3]));
      demands[i] = (demand);//需求
      int windowStart = (int)(Double.parseDouble(tokens[4]));
      windowStarts[i] = (windowStart);
      int windowEnd = (int)(Double.parseDouble(tokens[5]));
      windowEnds[i] = (windowEnd);
      int serviceTime = (int)(Double.parseDouble(tokens[6]));
      serviceTimes[i] = (serviceTime);//服务时间
    }
    
    VrpProblem problem = new VrpProblem(demands, xCoors, yCoors, serviceTimes, 
        windowStarts, windowEnds, depotX, depotY, capacity);
    return problem;
  }
}
