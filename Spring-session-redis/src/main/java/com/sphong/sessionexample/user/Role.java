package com.sphong.sessionexample.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("GUEST","guest"),
    USER("USER","user");

    private final String key;
    private final String title;
}
