package com.sphong.sessionexample.web;

import com.sphong.sessionexample.SessionExampleApplication;
import com.sphong.sessionexample.dto.SignInRequestDto;
import com.sphong.sessionexample.user.SessionUser;
import com.sphong.sessionexample.user.User;
import com.sphong.sessionexample.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.startup.UserConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public Long loginPost(@RequestBody SignInRequestDto requestDto) {
        return userService.save(requestDto);
    }

}
