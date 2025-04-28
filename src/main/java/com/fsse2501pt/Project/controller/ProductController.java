package com.fsse2501pt.Project.controller;

import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.data.dto.GetAllProductResponseDto;
import com.fsse2501pt.Project.data.dto.ProductResponseDto;
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
    public List<GetAllProductResponseDto> getAllProduct(){
        List<GetAllProductResponseDto> dtoList = new ArrayList<>();

        for(ProductResponseData data: productService.getAllProduct()){
            dtoList.add(new GetAllProductResponseDto(data));

        }
        return dtoList;

    }

    @GetMapping("/{pid}")
    public ProductResponseDto getByPid(@PathVariable Integer pid){
        return new ProductResponseDto (
                productService.getProductById(pid)
        );
    }

}
