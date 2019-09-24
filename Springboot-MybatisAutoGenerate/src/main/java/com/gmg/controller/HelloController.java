package com.gmg.controller;

import com.gmg.bean.User;
import com.gmg.bean.UserExample;
import com.gmg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gmg
 * @title: HelloController
 * @projectName demo
 * @description: TODO
 * @date 2019/6/4 9:33
 */
@RestController
public class HelloController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ServletContext servletContext;

    //https://blog.csdn.net/biandous/article/details/65630783
    //https://blog.csdn.net/paincupid/article/details/50921110
    @RequestMapping("/selectUserExample")
    public List<User> selectUserExample(){
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo("gmg").andAgeBetween(5, 12);
        userExample.setOrderByClause("age desc");
        List<User> list = userMapper.selectByExample(userExample);
        return list;
    }

    @RequestMapping("/getCode")
    //    @ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR,reason="server error")
    public ResponseEntity<Map<String, Object>> getCode() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zhangsan");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.FORBIDDEN);
    }
}
