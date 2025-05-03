package com.fsse2501pt.Project.service;

import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.data.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    List<ProductResponseData> getAllProduct();

    ProductResponseData getProductById(Integer id);

    ProductEntity getProductByPid(Integer pid);

    boolean deductStock(Integer tid, Integer quantity);
}
