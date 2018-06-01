package com.example.demo.service;

import com.example.bean.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AmqpTemplate rabbitTemplate;
    public int updateUser(User user) throws Exception{
        Integer result = userMapper.updateUser(user);
     if (result>0){
         byte[] bytes=getBytesFromObject(user);
         this.rabbitTemplate.convertAndSend("exchange", "topic.messages", bytes);
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
