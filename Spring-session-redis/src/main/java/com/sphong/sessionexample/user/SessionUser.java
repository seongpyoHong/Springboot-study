package com.sphong.sessionexample.user;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String userId;
    private String userPw;

    public SessionUser(User user) {
        this.userId = user.getUserId();
        this.userPw = user.getUserPw();
    }
}
