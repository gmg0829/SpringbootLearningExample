package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class RabbitMqConsumeApplication{

   @Autowired
	UserInfoMapper userInfoMapper;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsumeApplication.class, args);
	}

	@RabbitListener(queues = "topic.message")
	public void receiver(String user){
		JSONObject jsonObject=JSONObject.parseObject(user);
		String name=jsonObject.getString("name");
		int id=jsonObject.getInteger("id");
		int age=jsonObject.getInteger("age");
		UserInfo userInfo=new UserInfo();
		userInfo.setName(name);
		userInfo.setUserId(id);
		userInfo.setAge(age);
		userInfoMapper.updateByUserid(userInfo);
	}
	}
