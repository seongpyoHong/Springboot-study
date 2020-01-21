package com.sphong.springsecurity.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequestDto {
    private  String email;
    private  String password;

    @Builder
    public AccountRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

