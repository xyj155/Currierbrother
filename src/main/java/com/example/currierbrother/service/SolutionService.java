package com.example.currierbrother.service;

import com.example.currierbrother.bean.Solution;

import java.util.List;

public interface SolutionService {
    void insertSolution(Solution solution);

    void deletAll();

    Solution getSolution(int id);

    List<Solution> getSolutionList();
}
