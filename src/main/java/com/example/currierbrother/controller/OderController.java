package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Order;
import com.example.currierbrother.service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/order")
@Controller
public class OderController {
    @Autowired
    private OrderServiceImpl service;

    @RequestMapping("/orderscan")
    public ModelAndView getOrderList(ModelAndView modelAndView) {
        modelAndView.setViewName("order.html");
        return modelAndView;
    }

    @RequestMapping("/oderlist")
    @ResponseBody
    public Order orderList() {
        Order orderList = service.getOrderList(1);
        return orderList;
    }
}
