package com.sphong.jwtinterceptor.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/")
    public String home () {
        return "home";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @GetMapping("/signin")
    public String signIn() {
        return "signIn";
    }

    @GetMapping("/userHome")
    public String userHome() {
        return "/userHome";
    }
}
