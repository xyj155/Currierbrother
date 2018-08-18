package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.Solution;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SolutionMapper {
    @Insert({"INSERT INTO solution (userid,packages) VALUES (#{userid},#{packages})"})
    void insertSolution(Solution solution);

    @Delete({"truncate table solution"})
    void deleteAll();

    @Select({"select * from solution"})
    List<Solution> getSolutionList();

    @Select({"select * from solution where userid = #{id}"})
    Solution getSolution(int id);
}
