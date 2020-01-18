package com.sphong.cors.demo.controller;

import com.sphong.cors.demo.domain.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //@CrossOrigin
    @GetMapping("/sphong")
    public User getUser() {
        User user = new User("sphong");
        return user;
    }
}
