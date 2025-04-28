package com.fsse2501pt.Project.service.Impl;

import com.fsse2501pt.Project.data.entity.ProductEntity;
import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.exception.ProductNotFoundException;
import com.fsse2501pt.Project.repository.ProductRepository;
import com.fsse2501pt.Project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger log = loggerFactory.getLogger(ProductServiceImpl.class);

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
    public ProductResponseData getProductById(Integer pId){
     try {
         return new ProductResponseData (getEntityByPid(pid));
     }catch(Exception ex){
         log.warn("Product getProductByPid failed:" + ex.getMessage());
         throw ex;
     }

    }

    @Override

    public ProductEntity getProductByPid(Integer pid) {

        if (productRepository.findById(id).isPresent()) {
            return
                    productRepository.findById(id).get();
        }
    };
    throw new ProductNotExist("Product Not Exist");

    }

