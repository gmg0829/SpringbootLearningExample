package com.gmg.user.service;

import java.util.List;

import com.gmg.user.domain.User;

public interface UserService {
	/**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String username, Integer id);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String username);

    /**
     * 获取用户总量
     */
    List<User> getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteByUser(String usernamee);

}
