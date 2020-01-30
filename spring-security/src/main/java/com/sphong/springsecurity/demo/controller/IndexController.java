package com.sphong.springsecurity.demo.controller;

import com.sphong.springsecurity.demo.dto.AccountRequestDto;
import com.sphong.springsecurity.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String create(AccountRequestDto account) {
        accountService.save(account);
        return "redirect:/login";
    }
}

