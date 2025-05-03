package com.fsse2501pt.Project.repository;

import com.fsse2501pt.Project.data.entity.CartItemEntity;
import com.fsse2501pt.Project.data.entity.ProductEntity;
import com.fsse2501pt.Project.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
    Optional<CartItemEntity>findByUserAndProduct(UserEntity user, ProductEntity product);

    List<CartItemEntity> findByUser(UserEntity user);

    void deleteAllByUser(UserEntity user);
}
