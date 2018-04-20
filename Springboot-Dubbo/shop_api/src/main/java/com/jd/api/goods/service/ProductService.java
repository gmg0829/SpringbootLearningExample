package com.jd.api.goods.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jd.api.goods.domain.Product;

import java.util.List;

/**
 * Created by gmg on 2017/11/25.
 */
@Service
public interface ProductService {
    List<Product> getAllProduct();
}
