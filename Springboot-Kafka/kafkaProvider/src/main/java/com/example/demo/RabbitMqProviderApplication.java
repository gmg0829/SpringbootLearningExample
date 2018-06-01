package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;


@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class RabbitMqProviderApplication  {
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProviderApplication.class, args);
	}

}
