package com.gmg.domain;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by gmg on on 2017-11-27 15:26.
 */
@ExcelTarget("User")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    /** 用户ID */
    @Excel(name = "用户id" , needMerge = true)
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名", needMerge = true)
    private String name;


    /** 用户年龄 */
    @Excel(name = "年龄", needMerge = true)
    private Integer age;

    @ExcelEntity(name = "商品")
    private Product product;

    /**购买的商品*/
    @ExcelCollection(name = "商品序列")
    private List<Product> products;

    /**创建时间*/
    @Excel(name = "创建时间" ,exportFormat="yyyy-MM-dd" , needMerge = true )
    private Date time;

    /**性别*/
    @Excel(name="性别" , replace={"男_1","女_0"}, needMerge = true)
    private int sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
