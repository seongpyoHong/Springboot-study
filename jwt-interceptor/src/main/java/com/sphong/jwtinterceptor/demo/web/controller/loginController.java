package com.sphong.jwtinterceptor.demo.web.controller;

import com.sphong.jwtinterceptor.demo.web.dto.SignInResponseDto;
import com.sphong.jwtinterceptor.demo.web.dto.SignupRequestDto;
import com.sphong.jwtinterceptor.demo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

        @Autowired
        private UserService userService;

        @PostMapping("/signUp")
        public String signUp(@RequestBody SignupRequestDto requestDto) throws IllegalAccessException {
            userService.signUp(requestDto);
            return "Sigh Up Success";
        }

        @PostMapping("/signIn")
        public SignInResponseDto signIn(@RequestBody SignupRequestDto requestDto) throws IllegalAccessException {
            return userService.signIn(requestDto);
        }
}
