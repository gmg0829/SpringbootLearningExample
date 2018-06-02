package com.example.demo.service;

import com.example.bean.User;
import com.example.demo.mapper.UserMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gmg on 2017/12/9.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;
    private Gson gson = new GsonBuilder().create();
    public int updateUser(User user) throws Exception{
        Integer result = userMapper.updateUser(user);
        if (result>0){
            kafkaTemplate.send("test", gson.toJson(user));
            return 1;
        }
        return 0;
    }

    //对象转化为字节码
    public  byte[] getBytesFromObject(Serializable obj) throws Exception {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(obj);
        return bo.toByteArray();
    }
}
