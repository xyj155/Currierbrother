package com.example.currierbrother.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/programme")
public class ProgramController {

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("programme.html");
        return modelAndView;
    }
}
