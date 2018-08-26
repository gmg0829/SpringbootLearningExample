package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gmg on on 2017-11-13 17:02.
 */
@Controller
public class WriteController {

    @RequestMapping("/home")
    @ResponseBody
    public String home(String name){
        throw new MyException("101", "gmg错误");
    }
}
