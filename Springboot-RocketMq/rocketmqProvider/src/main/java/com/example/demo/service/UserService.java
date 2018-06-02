package com.example.demo.service;

import com.example.bean.User;
import com.example.demo.config.RocketMQConfig;
import com.example.demo.mapper.UserMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


/**
 * Created by gmg on 2017/12/9.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RocketMQConfig rocketMQConfig;

    private Gson gson = new GsonBuilder().create();

    public int updateUser(User user) throws Exception{
        Integer upadteResult = userMapper.updateUser(user);
        DefaultMQProducer producer = new DefaultMQProducer(rocketMQConfig.getProducerGroup());
        if (upadteResult>0){
            try {
                //指定NameServer地址，多个地址以 ; 隔开
                producer.setNamesrvAddr(rocketMQConfig.getNamesrvAddr());
                producer.start();
                Message message = new Message("TopicTest", "push", gson.toJson(user).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult result = producer.send(message);
                System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                producer.shutdown();
            }

        }
        return 0;
    }


}
