package com.gmg.controller;

import com.gmg.jwt.JwtOperator;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author gmg
 * @title: JwtController
 * @projectName demo
 * @description: TODO
 * @date 2019/9/7 15:38
 */
@RestController
public class JwtController {

    @Autowired
    JwtOperator jwtOperator;

    @RequestMapping("generateToken")
    public String generateToken(){
        // 2.设置用户信息
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id", "1");
        objectObjectHashMap.put("userName", "gmg");

        String token = jwtOperator.generateToken(objectObjectHashMap);
        return token;
    }

    @RequestMapping("validateToken")
    public Boolean validateToken(String someToken){
        Boolean validateToken = jwtOperator.validateToken(someToken);
        return  validateToken;
    }

    @RequestMapping("getClaimsFromToken")
    public Claims getClaimsFromToken(String someToken){
        Claims claims = jwtOperator.getClaimsFromToken(someToken);
        return  claims;
    }


}
