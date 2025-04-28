package com.fsse2501pt.Project.service;

import com.fsse2501pt.Project.data.domainObject.ProductResponseData;

import java.util.List;

public interface ProductService {
    List<ProductResponseData> getAllProduct();

    ProductResponseData getProductById(Integer id);
}
