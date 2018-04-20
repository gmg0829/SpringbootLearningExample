package com.gmg.service;

import com.gmg.domain.User;

import java.util.List;

/**
 * Created by beikongguocai on 2017/4/26.
 */
public interface UserService {

     public User saveUserWithRollBack(User user);
     public User saveUserWithoutRollBack(User user);
     public User addUser(User user);
     public void remove(Integer id);
     public User findOne(Integer id);
}
