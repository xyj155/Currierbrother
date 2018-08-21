package com.example.currierbrother.service;

import com.example.currierbrother.bean.Daily;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface DailyService {
    List<Daily> getList();


    int insertDaily(Daily daily);



    void deletAll();


    Daily getDailyOrderById(int id);
}
