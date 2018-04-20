package com.wooyoo.learning;

import com.wooyoo.learning.dao.domain.Product;
import com.wooyoo.learning.dao.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/{id}")
    public Product getProductInfo(
            @PathVariable("id")
                    Long productId) {
        return productMapper.select(productId);
    }

    @RequestMapping(value = "/{id}",/*consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,*/method=RequestMethod.POST
           )
    public Product updateProductInfo(
            @PathVariable("id")
                    Long productId,
            @ModelAttribute
                    Product newProduct) {
        Product product = productMapper.select(productId);
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        productMapper.update(product);
        return product;
    }
}
