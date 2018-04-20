package com.gmg.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gmg.user.domain.User;
import com.gmg.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {
   @Autowired
   JdbcTemplate jdbcTemplate;
	@Override
	public void create(String username, Integer id) {
		String sql="insert into gmg(id,username) values(?,?)";
		jdbcTemplate.update(sql, id,username);
		
	}

	@Override
	public void deleteByName(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUsers() {
	  String sql="select * from gmg";
	  List<User> list=jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
		return list;
	}

	@Override
	public void deleteByUser(String usernamee) {
		// TODO Auto-generated method stub

	}

}
