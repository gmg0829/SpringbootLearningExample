package com.gmg.springbootmobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2018/8/20  13:42
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test() {
        return "test";
    }
}