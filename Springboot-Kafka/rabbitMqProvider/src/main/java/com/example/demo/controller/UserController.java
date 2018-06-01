package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmg on 2017/12/9.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "batch")
    public int batch(){
     return userService.getAll();
    }
}
