package com.example.demo.topic;

import com.example.demo.bean.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    @RabbitHandler
    public void receiver(User user){
        System.err.println(user.getName()+"---"+user.getAge());
    }

}
