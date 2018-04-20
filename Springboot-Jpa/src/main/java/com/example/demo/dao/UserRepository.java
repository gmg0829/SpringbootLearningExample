package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
   //and
    User findByAgeAndName(int age,String name);
    //or
    User findByAgeOrName(int age,String name);
    User findByName(int age,String name);
    //betwwen
    List<User> findByAgeBetween(int min,int max);
    //小于
    List<User> findByAgeLessThan(int age);
    //小于等于
    List<User> findByAgeLessThanEqual(int age);
    //大于
    List<User> findByAgeGreaterThan(int age);
    //是空
    List<User> 	findByAgeIsNull(int age);
    //非空
    List<User> 	findByAgeIsNotNull(int age);
    //like
    List<User>  findByNameLike(String name);
    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> 	findByNameContaining(String name);
    //where x.age = ?1 order by x.lastname desc
    List<User> 	findByAgeOrderByNameDesc(int age,String name);
    //不等于
    List<User> 	findByNameNot(String name);
    //where x.active = true
    List<User> 	findByNameTrue(String name);
    //
    List<User> 	findByNameFalse(String name);
    //忽略大小写
    List<User> 	findByNameIgnoreCase(String name);

   Integer countByName(String name);

   Integer deleteById(Long id);

  Page<User> findByName(Pageable pageable,String name);



}
