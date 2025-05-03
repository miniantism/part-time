package com.fsse2501pt.Project.service;

import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import com.fsse2501pt.Project.data.entity.UserEntity;

public interface UserService {
    UserEntity getEntityByFirebaseUserData (FirebaseUserData fireBaseUserData);

}
