package com.gmg.controller;

import com.gmg.domain.User;
import com.gmg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by beikongguocai on 2017/4/26.
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("rollback")
    public User addUserWithRoll(User user){

        return userService.saveUserWithRollBack(user);
    }
    @RequestMapping("norollback")
    public User addUserWithOutRoll(User user){

        return userService.saveUserWithoutRollBack(user);
    }

    @RequestMapping("add")
    public User add(User user){
        return userService.addUser(user);
    }
    @RequestMapping("delete")
    public void delete(Integer id){
        userService.remove(id);
    }
    @RequestMapping("find")
    public User find(Integer id){
        return userService.findOne(id);
    }
}
