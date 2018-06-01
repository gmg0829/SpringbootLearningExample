package com.example.demo.controller;

import com.example.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gmg on 2017/12/9.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "updateUser")
    public int updateUser(@RequestBody  User user) throws Exception{
        return userService.updateUser(user);
    }
}
