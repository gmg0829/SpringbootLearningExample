package com.example.bootdruid.entity;


/**
 * (UserRole)表实体类
 *
 * @author makejava
 * @since 2018-08-09 13:16:10
 */
public class UserRole {
    
    private Integer userId;
    
    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}