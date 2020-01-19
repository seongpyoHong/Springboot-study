package com.sphong.cors.demo.controller;

import com.sphong.cors.demo.domain.User;
import com.sphong.cors.demo.dto.UserResponseDto;
import com.sphong.cors.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    //@CrossOrigin
    @GetMapping("/user/{menu}")
    public UserResponseDto getUser(@PathVariable("menu") String menu) {
        System.out.println("Reached in UserController");
        return userService.findUserByMenu(menu);
    }
}
