package com.example.currierbrother.controller;

import com.example.currierbrother.bean.Car;
import com.example.currierbrother.service.serviceImpl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarServiceImpl carService;

    @ResponseBody
    @RequestMapping("/carlist")
    public List<Car> getCarlist() {
        return carService.carlist();
    }

    @RequestMapping("/carindex")
    public ModelAndView CarIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("carlist");
        return modelAndView;
    }
}
