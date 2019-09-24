package com.gmg.bean;

/**
 * @author gmg
 * @title: People
 * @projectName demo
 * @description: TODO
 * @date 2019/8/26 18:53
 */

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class People {

    private Integer id;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "未成年不能入内")
    private Integer age;

    @NotNull(message = "姓名不能为空")
    private String name;

    public People() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }
}

