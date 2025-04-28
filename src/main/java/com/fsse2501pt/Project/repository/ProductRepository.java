package com.fsse2501pt.Project.repository;

import com.fsse2501pt.Project.data.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
}
