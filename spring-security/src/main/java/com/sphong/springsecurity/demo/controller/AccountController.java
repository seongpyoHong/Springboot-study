package com.sphong.springsecurity.demo.controller;

import com.sphong.springsecurity.demo.domain.Account;
import com.sphong.springsecurity.demo.dto.AccountRequestDto;
import com.sphong.springsecurity.demo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    AccountService accountService;

    @PostMapping("/login")
    public UserDetails login(AccountRequestDto account) {
        return accountService.loadUserByUsername(account.getEmail());
    }
}
