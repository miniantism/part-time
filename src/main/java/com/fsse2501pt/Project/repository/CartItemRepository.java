package com.fsse2501pt.Project.repository;

import com.fsse2501pt.Project.data.entity.CartItemEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {
    Optional<CartItemEntity>findByUserAndProduct(UserEntity user, ProductEntity product);

    List<CartItemEntity>findByUser(UserEntity user);

}
