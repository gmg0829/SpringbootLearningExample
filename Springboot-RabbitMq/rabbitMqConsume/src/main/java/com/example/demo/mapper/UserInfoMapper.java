package com.example.demo.mapper;

import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by gmg on 2017/12/9.
 */
@Mapper
public interface UserInfoMapper {
 int updateByUserid(UserInfo user);
}
