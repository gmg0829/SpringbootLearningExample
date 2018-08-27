package com.example.demo.controller;

import com.example.demo.anno.MyLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/8/20  11:51
 */
@RestController
public class IndexController {
    @MyLog(value = "增加记录")  //这里添加了AOP的自定义注解
    @RequestMapping("/add")
    public String add(String name, int age) {
        return "成功";
    }

}
