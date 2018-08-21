package com.example.currierbrother.service;

import com.example.currierbrother.bean.OrderHistory;

import java.util.List;

public interface HistoryService {
    List<OrderHistory> getTodayAllHistory();

    int insert(OrderHistory history);

}
