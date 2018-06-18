package com.example.currierbrother.service;


import com.example.currierbrother.bean.User;

import java.util.List;

public interface UserService {
    User loginWithUser(User user);

    List<User> getUserList();
}
