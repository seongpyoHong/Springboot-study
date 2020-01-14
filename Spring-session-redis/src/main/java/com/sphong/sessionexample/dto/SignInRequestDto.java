package com.sphong.sessionexample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignInRequestDto {
    private final String userId;
    private final String userPw;
}
