package com.jd.server.goods.mapper;

import com.jd.api.goods.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by gmg on 2017/11/25.
 */
@Mapper
public interface ProductMapper {
    List<Product> selectAll();
}
