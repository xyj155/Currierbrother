package com.example.currierbrother.service.serviceImpl;



import com.example.currierbrother.bean.User;
import com.example.currierbrother.mapper.UserMapper;
import com.example.currierbrother.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper mapMapper=null;


    @Override
    public User loginWithUser(String username, String password) {
        return null;
    }
}
