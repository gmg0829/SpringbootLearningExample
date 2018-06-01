package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.bean.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class RabbitMqConsumeApplication{



	public static void main(String[] args) {
		SpringApplication.run(RabbitMqConsumeApplication.class, args);
	}


	}
