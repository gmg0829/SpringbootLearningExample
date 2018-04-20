package com.gmg.domain;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.util.Date;

/**
 * Created by gmg on on 2017-12-11 10:09.
 */
public class StudentEntity implements java.io.Serializable {
    /**
     * id
     */
    private String  id;
    /**
     * 学生姓名
     */
    @Excel(name = "学生姓名", height = 20, width = 30)
    private String name;
    /**
     * 学生性别
     */
    @Excel(name = "学生性别", replace = { "男_1", "女_2" }, suffix = "生")
    private int sex;

  //  @Excel(name = "出生日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd", width = 20)
    private Date birthday;

    //@Excel(name = "进校日期", databaseFormat = "yyyyMMddHHmmss", format = "yyyy-MM-dd")
    private Date registrationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}