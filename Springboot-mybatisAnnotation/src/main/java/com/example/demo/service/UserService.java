/**
 * 
 */
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;

/** 
* @ClassName: UserService 
* @Description: TODO
* @author gmg 
* @date 2017年8月15日 上午10:10:31  
*/
@Service
public class UserService {
    @Autowired
	UserDao userDao;
  public User findById(int id){
	  return userDao.findById(id);
  }
}
