package com.example.bootdruid.entity;

import java.util.Date;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2018-08-09 13:15:25
 */
public class User {
    
    private Integer id;
    //用户名
    private String username;
    //手机号
    private String mobile;
    //邮箱
    private String email;
    //密码
    private String password;
    //添加该用户的用户id
    private Integer insertUid;
    //注册时间
    private Date insertTime;
    //修改时间
    private Date updateTime;
    //是否删除（0：正常；1：已删）
    private Integer isDel;
    //是否在职（0：正常；1，离职）
    private Integer isJob;
    //短信验证码
    private String mcode;
    //短信发送时间
    private Date sendTime;
    //更新版本
    private Integer version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getInsertUid() {
        return insertUid;
    }

    public void setInsertUid(Integer insertUid) {
        this.insertUid = insertUid;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsJob() {
        return isJob;
    }

    public void setIsJob(Integer isJob) {
        this.isJob = isJob;
    }

    public String getMcode() {
        return mcode;
    }

    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}