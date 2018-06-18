package com.example.currierbrother.vrp;



import i.VrpGreedyInitializer;
import i.VrpReader;
import problem.VrpProblem;
import problem.VrpSolution;
import viz.VrpPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class test {

    public static void main(String[] args) throws IOException {
        File f = new File("D:\\IdeaProjects\\Currierbrother\\src\\main\\java\\com\\example\\currierbrother\\vrp\\rc110_1.txt");
        VrpProblem problem = VrpReader.readSolomon(f, 200);
        // seems like more for the first two and less for the last works
        VrpGreedyInitializer init = new VrpGreedyInitializer(1.0, 1.0, 0);
        VrpSolution sol = init.nearestNeighborHeuristic(problem);
        System.out.println("车辆数："+sol.getNumVehicles());
        System.out.println("花费时间："+sol.getToursCost());
        System.out.println("是否解决问题："+sol.verify(problem));
        System.out.println("路线方案："+sol.getRoutes());
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VrpPanel panel = new VrpPanel();
        panel.setScale(problem);
        panel.setSolution(sol);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("蚁群算法之快递路径规划方案");
    }
}
