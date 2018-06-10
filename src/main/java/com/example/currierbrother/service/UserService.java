package com.example.currierbrother.service;


import com.example.currierbrother.bean.User;

public interface UserService {
    User loginWithUser(String username, String password);
}
