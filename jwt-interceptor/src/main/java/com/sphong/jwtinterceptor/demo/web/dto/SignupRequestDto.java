package com.sphong.jwtinterceptor.demo.web.dto;

import lombok.Getter;

@Getter
public class SignupRequestDto {
    private String userPw;
    private String userEmail;
    private String token;
}
