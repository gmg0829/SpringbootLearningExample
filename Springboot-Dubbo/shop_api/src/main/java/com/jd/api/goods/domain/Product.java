package com.jd.api.goods.domain;

import java.io.Serializable;

/**
 * Created by gmg on 2017/11/25.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -1L;
    private int id;
    private String name;

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
}
