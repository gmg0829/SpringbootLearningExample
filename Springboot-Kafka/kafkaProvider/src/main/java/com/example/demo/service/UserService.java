package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gmg on 2017/12/9.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private Producer producer;
    public int getAll() {
        List<User> all = userMapper.selectAll();
        int count = 0;
        if (all.size() > 0) {
            for (User a : all) {
                JSONObject data = new JSONObject();
                data.put("id",a.getId());
                data.put("name",a.getName());
                data.put("age",a.getAge());
                producer.send(new SampleMessage(1, "你好"));
                count++;
            }

        }
        return 0;
    }
}
