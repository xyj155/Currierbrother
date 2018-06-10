package com.example.currierbrother.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class Index {
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index.html");
        return modelAndView;
    }
}
