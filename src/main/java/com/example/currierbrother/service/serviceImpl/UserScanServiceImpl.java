package com.example.currierbrother.service.serviceImpl;


import com.example.currierbrother.bean.UserScan;

import com.example.currierbrother.mapper.UserScanMapper;
import com.example.currierbrother.service.UserScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScanServiceImpl implements UserScanService {
    @Autowired
    private UserScanMapper mapper;
    @Override
    public List<UserScan> getAllList() {
        List<UserScan> userScans = mapper.selectAllList();
        return userScans;
    }
}
