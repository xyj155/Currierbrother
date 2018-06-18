package com.example.currierbrother.mapper;


import com.example.currierbrother.bean.UserScan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserScanMapper {

    @Insert("INSERT INTO userscan (ordernum,username,idcard,usertel,startlocation,endlocation) " +
            "VALUES" + " (#{ordernum},#{ordernum},#{idcard},#{usertel},#{startlocation},#{endlocation})")
    int insert(UserScan userScan);

    int insertSelective(UserScan record);

    UserScan selectByPrimaryKey(Integer id);

    @Update("UPDATE userscan SET ordernum = #{ordernum} ," +
            " username = #{username} , idcard = #{idcard} ," +
            " usertel= #{usertel} , startlocation = #{startlocation} ," +
            " endlocation= #{endlocation} WHERE id = #{id}")
    int updateByPrimaryKeySelective(UserScan record);

    int updateByPrimaryKey(UserScan record);

    @Select("select * from userscan")
    List<UserScan> selectAllList();

    @Delete("DELETE FROM userscan WHERE id=#{id}")
    int deleteByPrimaryKey(Integer id);

}