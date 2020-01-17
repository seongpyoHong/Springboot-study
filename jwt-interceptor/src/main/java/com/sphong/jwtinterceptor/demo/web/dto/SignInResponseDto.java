package com.sphong.jwtinterceptor.demo.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SignInResponseDto {
    private final String token;
}
