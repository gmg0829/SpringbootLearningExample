package com.gmg.controller;

import com.gmg.bean.User;
import com.gmg.bean.UserExample;
import com.gmg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gmg
 * @title: HelloController
 * @projectName demo
 * @description: TODO
 * @date 2019/6/4 9:33
 */
@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;
   //https://blog.csdn.net/biandous/article/details/65630783
    //https://blog.csdn.net/paincupid/article/details/50921110
    @RequestMapping("/selectUserExample")
    public List<User> selectUserExample(){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("gmg").andAgeBetween(5,12);
        userExample.setOrderByClause("age desc");
        List<User> list=userMapper.selectByExample(userExample);
        return list;
    }
}
