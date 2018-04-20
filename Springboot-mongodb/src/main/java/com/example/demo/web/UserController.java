package com.example.demo.web;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by gmg on on 2017-11-22 11:38.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository demoInfoRepository;

    @RequestMapping("save")
    public String save(){
        User demoInfo = new User();
        demoInfo.setUsername("张三");
        demoInfo.setAge(20);
        demoInfoRepository.save(demoInfo);

        demoInfo = new User();
        demoInfo.setUsername("李四");
        demoInfo.setAge(30);
        demoInfoRepository.save(demoInfo);

        return "ok";
    }

    @RequestMapping("find")
    public List<User> find(){
        return demoInfoRepository.findAll();
    }

    @RequestMapping("findByName")
    public User findByName(){
        return demoInfoRepository.findByUsername("张三");
    }

    @RequestMapping("getCount")
    public long getCount(){
        return  demoInfoRepository.count();
    }
    @RequestMapping("getByUserNameLike")
    public List<User> getByUserNameLike(){
        return  demoInfoRepository.findByUsernameLike("张");
    }

    @RequestMapping("getByUserNameLikePage")
    public List<User> getByUserNameLikePage(){
        PageRequest pageRequest = new PageRequest(0,2);
        return  demoInfoRepository.findByUsernameLike("张",pageRequest).getContent();
    }

    @RequestMapping("findByAgeBetween")
    public List<User> findByAgeBetween(){
        return  demoInfoRepository.findByAgeLessThan(40);
    }

    @RequestMapping("findByAgeGreaterThan")
    public String findByAgeGreaterThan(){

        return "success";
    }





}
