package com.example.currierbrother.mapper;

import com.example.currierbrother.bean.UserScan;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserScanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserScan record);

    int insertSelective(UserScan record);

    UserScan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserScan record);

    int updateByPrimaryKey(UserScan record);

    @Select("select * from userscan")
    List<UserScan> selectAllList();
}