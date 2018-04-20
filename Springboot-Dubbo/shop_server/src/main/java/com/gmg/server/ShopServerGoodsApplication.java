package com.gmg.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jd.server.goods.mapper")
public class ShopServerGoodsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopServerGoodsApplication.class, args);
	}
}
