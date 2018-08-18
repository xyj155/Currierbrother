package com.example.currierbrother.service.serviceImpl;


import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.bean.Express;
import com.example.currierbrother.bean.Order;
import com.example.currierbrother.mapper.DailyMapper;
import com.example.currierbrother.mapper.OrderMapper;
import com.example.currierbrother.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper = null;
    @Autowired
    private DailyMapper dailyMapper = null;

    public OrderServiceImpl() {
    }

    @Override
    public Order getOrderList(int i) {
        Order order = this.mapper.selectByPrimaryKey(i);
        return order;
    }

    @Override
    public void deletKey(int i) {
        mapper.deleteByPrimaryKey(i);
    }

    @Override
    public Daily getExpressByUid(int id) {
        return dailyMapper.getExpressByUid(id);
    }

    @Override
    public List<Express> getDailyPackage() {
        return mapper.getDailyPackage();
    }
}
