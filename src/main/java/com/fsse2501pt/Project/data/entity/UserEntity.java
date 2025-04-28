package com.fsse2501pt.Project.data.entity;

import com.fsse2501pt.Project.data.domainObject.FireBaseUserData;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false, unique = true)
    private String fireBaseUid;

    public UserEntity() {
    }

    public UserEntity(FireBaseUserData fireBaseUserData) {
        this.email = fireBaseUserData.getEmail();
        this.fireBaseUid = fireBaseUserData.getFirebaseUid();
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
        return fireBaseUid;
    }

    public void setFireBaseUid(String fireBaseUid) {
        this.fireBaseUid = fireBaseUid;
    }
}
