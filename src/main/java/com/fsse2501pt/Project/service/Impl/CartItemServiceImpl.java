package com.fsse2501pt.Project.service.Impl;

import com.fsse2501pt.Project.data.domainObject.CartItemResponseData;
import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import com.fsse2501pt.Project.data.entity.CartItemEntity;

import com.fsse2501pt.Project.data.entity.ProductEntity;
import com.fsse2501pt.Project.data.entity.UserEntity;
import com.fsse2501pt.Project.exception.ProductNotFoundException;
import com.fsse2501pt.Project.repository.CartItemRepository;
import com.fsse2501pt.Project.service.CartItemService;
import com.fsse2501pt.Project.service.ProductService;
import com.fsse2501pt.Project.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void putCartItem(FirebaseUserData fireBaseUserData, Integer pid, Integer quantity) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(fireBaseUserData);
        ProductEntity productEntity = productService.getProductByPid(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity,productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()) {
            cartItemEntity = existingCartItem.get();
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);

        } else {
            cartItemEntity = new CartItemEntity(userEntity, productEntity, quantity);
        }
        cartItemRepository.save(cartItemEntity);


    }

    @Override
    public List<CartItemResponseData> getCartItemList(FirebaseUserData fireBaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(fireBaseUserData);
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemRepository.findByUser(userEntity)) {
            cartItemResponseDataList.add(
                    new CartItemResponseData(cartItemEntity));

        }
        return cartItemResponseDataList;
    }


    @Override
    public CartItemResponseData updateItem(Integer pid, Integer quantity, FirebaseUserData fireBaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(fireBaseUserData);
        ProductEntity productEntity = productService.getProductByPid(pid);

        if (cartItemRepository.findByUserAndProduct(userEntity, productEntity).isPresent()) {
            CartItemEntity existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity).get();
            existingCartItem.setQuantity(quantity);
            cartItemRepository.save(existingCartItem);
            return new CartItemResponseData(existingCartItem);
        }
        throw new ProductNotFoundException(pid);
    }

    @Transactional
    @Override
    public void deleteItem(Integer pid, FirebaseUserData fireBaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(fireBaseUserData);
        ProductEntity productEntity = productService.getProductByPid(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()) {
            cartItemEntity = existingCartItem.get();
            cartItemRepository.delete(cartItemEntity);
        } else {
            throw new ProductNotFoundException(pid);
        }
    }

    // because have change to roll back, so  mark "@transactional"
    @Transactional
    @Override
    public void emptyCart(UserEntity userEntity){
        cartItemRepository.deleteAllByUser(userEntity);
    }



    @Override
    public List<CartItemEntity> getCartItemListByUserEntity (UserEntity userEntity){
        return cartItemRepository.findByUser(userEntity);

    }
}