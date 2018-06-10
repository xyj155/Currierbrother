package com.example.currierbrother.service.serviceImpl;


import com.example.currierbrother.bean.Order;
import com.example.currierbrother.mapper.OrderMapper;
import com.example.currierbrother.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper mapper=null;


    @Override
    public Order getOrderList(int i) {
        Order order = mapper.selectByPrimaryKey(i);
        return  order;
    }
}
