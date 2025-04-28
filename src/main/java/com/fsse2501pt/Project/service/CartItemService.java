package com.fsse2501pt.Project.service;

import com.fsse2501pt.Project.data.domainObject.CartItemResponseData;
import com.fsse2501pt.Project.data.domainObject.FireBaseUserData;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartItemService {
    void putCartItem(FireBaseUserData fireBaseUserData, Integer pid, Integer quantity);

    List<CartItemResponseData> getCartItemList(FireBaseUserData fireBaseUserData);

    CartItemResponseData updateItem(Integer pid, Integer quantity, FireBaseUserData fireBaseUserData);

    @Transactional
    void deleteItem(Integer pid, FireBaseUserData fireBaseUserData);
}
