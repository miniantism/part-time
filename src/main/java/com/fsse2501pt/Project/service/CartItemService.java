package com.fsse2501pt.Project.service;

import com.fsse2501pt.Project.data.domainObject.CartItemResponseData;
import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import com.fsse2501pt.Project.data.entity.CartItemEntity;
import com.fsse2501pt.Project.data.entity.TransactionEntity;
import com.fsse2501pt.Project.data.entity.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartItemService {
    void putCartItem(FirebaseUserData fireBaseUserData, Integer pid, Integer quantity);

    List<CartItemResponseData> getCartItemList(FirebaseUserData fireBaseUserData);

    CartItemResponseData updateItem(Integer pid, Integer quantity, FirebaseUserData fireBaseUserData);

    @Transactional
    void deleteItem(Integer pid, FirebaseUserData fireBaseUserData);

    // because have change to roll back, so  mark "@transactional"
    @Transactional
    void emptyCart(UserEntity userEntity);

    List<CartItemEntity> getCartItemListByUserEntity (UserEntity userEntity);


}
