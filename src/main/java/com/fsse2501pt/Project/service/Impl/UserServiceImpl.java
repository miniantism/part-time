package com.fsse2501pt.Project.service.Impl;

import com.fsse2501pt.Project.data.domainObject.FireBaseUserData;
import com.fsse2501pt.Project.data.entity.UserEntity;
import com.fsse2501pt.Project.repository.UserRepository;
import com.fsse2501pt.Project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity getEntityByEmail (FireBaseUserData fireBaseUserData) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(fireBaseUserData.getEmail());

        if(optionalUserEntity.isPresent()){
            return optionalUserEntity.get();
        }
        UserEntity userEntity = new UserEntity(fireBaseUserData);
        return userRepository.save(userEntity);

       //(3rd level coding)
        //return userRepository.findByEmail(fireBaseUserData.getEmail().orElseGet(
        //() -> userRepository.save(new UserEntity(fireBaseUserData))
    }
}
