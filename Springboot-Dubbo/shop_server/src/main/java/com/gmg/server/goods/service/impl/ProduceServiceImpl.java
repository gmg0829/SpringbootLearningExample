package com.gmg.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.jd.api.goods.domain.Product;
import com.jd.api.goods.service.ProductService;
import com.jd.server.goods.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gmg on 2017/11/25.
 */
@Service
public class ProduceServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> getAllProduct() {
        return productMapper.selectAll();
    }
}
