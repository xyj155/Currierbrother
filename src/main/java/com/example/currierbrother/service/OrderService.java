package com.example.currierbrother.service;



import com.example.currierbrother.bean.Daily;
import com.example.currierbrother.bean.Express;
import com.example.currierbrother.bean.Order;

import java.util.List;

public interface OrderService {
   Order getOrderList(int i);

   void deletKey(int i);

   Daily getExpressByUid(int id);

   List<Express> getDailyPackage();
}
