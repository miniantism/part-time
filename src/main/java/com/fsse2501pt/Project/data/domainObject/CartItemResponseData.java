package com.fsse2501pt.Project.data.domainObject;

import com.fsse2501pt.Project.data.entity.CartItemEntity;
import com.fsse2501pt.Project.data.entity.ProductEntity;
import com.fsse2501pt.Project.data.entity.UserEntity;

public class CartItemResponseData {
    private Integer cid;
    private ProductEntity productEntity;
    private UserEntity userEntity;
    private Integer quantity;

    //(constructor)
    public CartItemResponseData(CartItemEntity cartItemEntity) {
        this.cid = cartItemEntity.getCid();
        this.productEntity = cartItemEntity.getProduct();
        this.userEntity = cartItemEntity.getUser();
        this.quantity = cartItemEntity.getQuantity();

    }

    //(getter and setter)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public static ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
