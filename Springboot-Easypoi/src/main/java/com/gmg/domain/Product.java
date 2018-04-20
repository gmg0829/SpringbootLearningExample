package com.gmg.domain;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gmg on on 2017-11-27 15:24.
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    @Excel(name = "商品名", needMerge = true)
    private String name;
    @Excel(name = "价格", needMerge = true)
    private double price;
    @Excel(name = "购买时间", exportFormat="yyyy/mm/dd", needMerge = true)
    private Date time;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
}
