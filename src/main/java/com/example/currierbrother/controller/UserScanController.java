package com.example.currierbrother.controller;


import com.example.currierbrother.bean.UserScan;
import com.example.currierbrother.service.serviceImpl.UserScanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//扫描的订单
@Controller
@RequestMapping("/userscan")
public class UserScanController {
    @Autowired
    private UserScanServiceImpl scan;

    /**
     * 订单界面
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/orderscan")
    public ModelAndView getOrderList(ModelAndView modelAndView) {
        modelAndView.setViewName("order.html");
        return modelAndView;
    }

    /**
     * 获取订单列表
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<UserScan> getList() {
        List<UserScan> allList = scan.getAllList();
        return allList;
    }

    /**
     * 删除id指向的数据
     *
     * @param key
     */
    @RequestMapping("/deleteorder")
    @ResponseBody
    public void deleteByKey(int key) {
        scan.deleteByKey(key);
        System.out.println("删除成功");
    }

    /**
     * 插入数据
     *
     * @param ordernum      订单编号
     * @param username      用户名
     * @param idcard        用户身份证
     * @param startlocation 出发点
     * @param endlocation   终点
     */
    @RequestMapping("/insert")
    @ResponseBody
    public void insertOrder(String ordernum,
                            String username,
                            String idcard,
                            String usertel,
                            String startlocation,
                            String endlocation) {
        UserScan userScan = new UserScan();
        userScan.setOrdernum(ordernum);
        userScan.setUsername(username);
        userScan.setIdcard(idcard);
        userScan.setUsertel(usertel);
        userScan.setStartlocation(startlocation);
        userScan.setEndlocation(endlocation);
        scan.insertData(userScan);
        System.out.println("插入成功");
    }

    /**
     * 更新数据
     *
     * @param ordernum      订单编号
     * @param username      用户名
     * @param idcard        用户身份证
     * @param startlocation 出发点
     * @param endlocation   终点
     * @param id            订单ID
     */
    @RequestMapping("/update")
    @ResponseBody
    public void updatetOrder(String ordernum,
                             String username,
                             String idcard,
                             String usertel,
                             String startlocation,
                             String endlocation, int id) {
        UserScan userScan = new UserScan();
        userScan.setOrdernum(ordernum);
        userScan.setUsername(username);
        userScan.setIdcard(idcard);
        userScan.setUsertel(usertel);
        userScan.setStartlocation(startlocation);
        userScan.setEndlocation(endlocation);
        userScan.setId(id);
        scan.updateOrder(userScan);
    }
}
