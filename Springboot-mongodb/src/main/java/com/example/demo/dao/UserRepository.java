package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by gmg on on 2017-11-22 11:36.
 */
public interface UserRepository extends MongoRepository<User,String>{
    User findByUsername(String username);

    List<User> findByUsernameLike(String username);

    public Page<User> findByUsernameLike(String name, Pageable pageable);

    List<User> findByAgeLessThan(int max);


}
