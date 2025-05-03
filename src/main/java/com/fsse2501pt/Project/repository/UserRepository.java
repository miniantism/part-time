package com.fsse2501pt.Project.repository;

import com.fsse2501pt.Project.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail (String email);



}
