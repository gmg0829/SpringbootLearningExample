package com.example.demo.web;

import com.example.demo.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gmg on on 2018-01-12 15:14.
 */
@RestController
@RequestMapping(value="/mongodbdemo")
public class MongoDemo
{
    @Autowired
    BaseDao baseDao;
    @RequestMapping("/getAll")
    public List<Map> getAll(){
         return  baseDao.findAll("user");
    }

    @RequestMapping("/save")
    public String save(){
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        map1.put("name","gmg");
        map1.put("count",45);
        map.put("data",map1);
        map.put("did","10");
        baseDao.save("user",map);
        return "success";
    }
    @RequestMapping("/delete")
public String delete(){
    baseDao.delete("5a14f389c9419423dcbb3b4b","user");
    return "success";
}
    @RequestMapping("/update")
    public String update(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","gmg");
        map.put("age",8);
        baseDao.update("5a14f389c9419423dcbb3b4c","user",map);
        return "success";
    }
    @RequestMapping("/findOne")
    public Object findOne(){
        return  baseDao.findOne("5a14f389c9419423dcbb3b4c","user");
    }




}
