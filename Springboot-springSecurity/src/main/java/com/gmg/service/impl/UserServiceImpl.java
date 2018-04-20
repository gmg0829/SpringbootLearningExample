package com.gmg.service.impl;

import com.gmg.domain.User;
import com.gmg.repository.UserRepository;
import com.gmg.service.UserService;
import org.apache.commons.logging.Log;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by beikongguocai on 2017/4/26.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public User  saveUserWithRollBack(User user){
       User u=userRepository.save(user);
        if(user.getName().equals("gmg")){
            throw new IllegalArgumentException("用户存在，回滚");
        }
        return  u;
    }
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public User  saveUserWithoutRollBack(User user){
        User u=userRepository.save(user);
        if(user.getName().equals("gmg")){
            throw new IllegalArgumentException("用户存在，数据不回滚");
        }
        return  u;
    }
    @CachePut(value = "users",key = "#user.id")
    public User addUser(User user){
         User u=userRepository.save(user);
        System.out.print("增加"+u.getId()+"做了缓存");
        return  u;
    }
    @CacheEvict(value = "users")
    public void remove(Integer id){
        System.out.print("删除"+id+"做了缓存");
        userRepository.delete(id);
    }
    @Cacheable(value="users")
    public User findOne(Integer id){
        User u=userRepository.findOne(id);
        System.out.print("获取"+u.getId()+"做了缓存");
        return u;
    }

}
