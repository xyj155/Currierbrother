package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where username=#{username} and password=#{password}")
    User loginByUsername(User user);

    @Select("select * from user")
    List<User> getUserList();
}