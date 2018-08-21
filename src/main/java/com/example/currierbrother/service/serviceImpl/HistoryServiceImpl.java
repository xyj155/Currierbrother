package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.OrderHistory;
import com.example.currierbrother.mapper.OrderHistoryMapper;
import com.example.currierbrother.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private OrderHistoryMapper mapper;
    @Override
    public List<OrderHistory> getTodayAllHistory() {
        return mapper.getTodayAllHistory();
    }

    @Override
    public int insert(OrderHistory history) {
        mapper.insert(history);
        return 1;
    }
}
