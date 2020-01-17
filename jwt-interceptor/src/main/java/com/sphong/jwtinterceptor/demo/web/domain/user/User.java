package com.sphong.jwtinterceptor.demo.web.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userPw;
    private String userEmail;
    private String token;

    @Builder
    public User(String userPw, String userEmail, String token) {
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.token = token;

    }
}

