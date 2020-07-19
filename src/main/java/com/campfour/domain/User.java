package com.campfour.domain;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String nickname;
    private String email;


    private String snsType;
    private String snsId;
    private LocalDateTime snsConnectDate;

    @Builder
    public User(String nickname, String email, String snsType, String snsId) {
        this.nickname = nickname;
        this.email = email;
        this.snsType = snsType;
        this.snsId = snsId;
        this.snsConnectDate = LocalDateTime.now();
    }
}
