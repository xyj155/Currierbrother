package com.example.currierbrother.controller;

import com.example.currierbrother.bean.User;
import com.example.currierbrother.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/loginindex")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/usermanager")
    public ModelAndView usermanager(ModelAndView modelAndView) {
        modelAndView.setViewName("usermanager");
        return modelAndView;
    }


    @RequestMapping("/login")
    @ResponseBody
    public User loginPage(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.loginWithUser(user);
    }

    @RequestMapping("/getuserlist")
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
