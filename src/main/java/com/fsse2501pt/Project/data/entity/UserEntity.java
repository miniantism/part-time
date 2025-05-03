package com.fsse2501pt.Project.data.entity;

import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer uid;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false, unique = true)
    private String firebaseUid;

    public UserEntity() {
    }

    public UserEntity(FirebaseUserData fireBaseUserData) {
        this.email = fireBaseUserData.getEmail();
        this.firebaseUid = fireBaseUserData.getFirebaseUid();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFireBaseUid() {
        return firebaseUid;
    }

    public void setFireBaseUid(String fireBaseUid) {
        this.firebaseUid = firebaseUid;
    }
}
