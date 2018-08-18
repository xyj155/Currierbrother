package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.Solution;
import com.example.currierbrother.mapper.SolutionMapper;
import com.example.currierbrother.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    private SolutionMapper solutionMapper;

    public SolutionServiceImpl() {
    }

    @Override
    public void insertSolution(Solution solution) {
        this.solutionMapper.insertSolution(solution);
    }

    @Override
    public void deletAll() {
        this.solutionMapper.deleteAll();
    }

    @Override
    public Solution getSolution(int id) {
        return this.solutionMapper.getSolution(id);
    }

    @Override
    public List<Solution> getSolutionList() {
        return this.solutionMapper.getSolutionList();
    }
}
