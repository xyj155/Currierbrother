package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.mapper.DailyMapper;
import com.example.currierbrother.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public List<Daily> getList() {
        return dailyMapper.getList();
    }
}
