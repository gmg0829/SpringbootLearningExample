package com.jd.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jd.api.goods.domain.Product;
import com.jd.api.goods.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * Created by gmg on 2017/11/25.
 */
@Controller
public class ProductController {
    @Reference
    ProductService productService;
    @RequestMapping("/getAllProduct")
    @ResponseBody
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }


}
