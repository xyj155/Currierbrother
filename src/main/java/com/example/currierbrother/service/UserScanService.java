package com.example.currierbrother.service;


import com.example.currierbrother.bean.UserScan;

import java.util.List;

public interface UserScanService {
    List<UserScan> getAllList();

    void deleteByKey(int key);

    int insertData(UserScan userScan);

    int updateOrder( UserScan userScan);
}
