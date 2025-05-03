package com.fsse2501pt.Project.data.dto;

import com.fsse2501pt.Project.data.domainObject.ProductResponseData;
import com.fsse2501pt.Project.data.domainObject.TransactionProductResponseData;

import java.math.BigDecimal;

public class ProductByIdResponseDto {
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;


    public ProductByIdResponseDto(ProductResponseData productByIdResponseDto) {
        this.pid = productByIdResponseDto.getPid();
        this.name = productByIdResponseDto.getName();
        this.description = productByIdResponseDto.getDescription();
        this.imageUrl = productByIdResponseDto.getImageUrl();
        this.price = productByIdResponseDto.getPrice();
        this.stock = productByIdResponseDto.getStock();

    }
    public ProductByIdResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.pid = transactionProductResponseData.getPid();
        this.name = transactionProductResponseData.getName();
        this.description = transactionProductResponseData.getDescription();
        this.imageUrl = transactionProductResponseData.getImageUrl();
        this.price = transactionProductResponseData.getPrice();
        this.stock = transactionProductResponseData.getStock();

    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
