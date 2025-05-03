package com.fsse2501pt.Project.service.Impl;

import com.fsse2501pt.Project.data.entity.ProductEntity;
import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.exception.ProductNotFoundException;
import com.fsse2501pt.Project.repository.ProductRepository;
import com.fsse2501pt.Project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponseData> getAllProduct(){
        List<ProductResponseData> responseDataList = new ArrayList<>();

        for(ProductEntity entity: productRepository.findAll()){
            responseDataList.add(new ProductResponseData(entity));
        }

        return responseDataList;
    }

    @Override
    public ProductResponseData getProductById(Integer pid){
     try {
         return new ProductResponseData (getProductByPid(pid));
     }catch(Exception ex){
         log.warn("Product getProductByPid failed:" + ex.getMessage());
         throw ex;
     }

    }

    @Override
    public ProductEntity getProductByPid(Integer pid) {

        if (productRepository.findById(pid).isPresent()) {
            return
                    productRepository.findById(pid).get();
        }

        throw new ProductNotFoundException(pid);

    }

    @Override
    public boolean deductStock(Integer pid, Integer quantity) {

        ProductEntity productEntity = productRepository.findById(pid).orElseThrow(() -> new RuntimeException());

        if (productEntity.getStock() < quantity) {
            throw new RuntimeException();

        }

        productEntity.setStock(productEntity.getStock() - quantity);
        productRepository.save(productEntity);
        return true;

    }


}


