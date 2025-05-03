package com.fsse2501pt.Project.controller;

import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.data.dto.ProductGetAllResponseDto;
import com.fsse2501pt.Project.data.dto.ProductByIdResponseDto;
import com.fsse2501pt.Project.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService){
        this.productService = productService;
    }
@GetMapping
    public List<ProductGetAllResponseDto> getAllProduct(){
        List<ProductGetAllResponseDto> dtoList = new ArrayList<>();

        for(ProductResponseData data: productService.getAllProduct()){
            dtoList.add(new ProductGetAllResponseDto(data));

        }
        return dtoList;

    }

    @GetMapping("/{pid}")
    public ProductByIdResponseDto getByPid(@PathVariable Integer pid){
        return new ProductByIdResponseDto(
                productService.getProductById(pid));

    }

}
