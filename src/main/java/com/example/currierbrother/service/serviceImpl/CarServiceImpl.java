package com.example.currierbrother.service.serviceImpl;

import com.example.currierbrother.bean.Car;
import com.example.currierbrother.mapper.CarMapper;
import com.example.currierbrother.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> carlist() {
        return carMapper.carlist();
    }
}
