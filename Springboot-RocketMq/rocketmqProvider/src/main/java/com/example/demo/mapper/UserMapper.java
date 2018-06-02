package com.example.demo.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by gmg on 2017/12/9.
 */
@Mapper
public interface UserMapper {
    Integer  updateUser(User user);
}
