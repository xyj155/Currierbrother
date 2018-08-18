package com.example.currierbrother.controller;

import com.example.currierbrother.bean.User;
import com.example.currierbrother.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 登录界面
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/usermanager")
    public ModelAndView usermanager(ModelAndView modelAndView) {
        modelAndView.setViewName("usermanager");
        return modelAndView;
    }

    /***
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public int loginPage(String username, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.loginWithUser(user);
        if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
            session.setAttribute("user",user);
            return 1;
        } else {
            return 0;
        }

    }


    @RequestMapping("/getuserlist")
    @ResponseBody
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
