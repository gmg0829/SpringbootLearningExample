package com.example.demo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by gmg on on 2017-11-22 11:34.
 */
public class User {

    private String username;
    private Integer age;

    public User() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
