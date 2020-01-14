package com.sphong.sessionexample.web;

import com.sphong.sessionexample.dto.SignInRequestDto;
import com.sphong.sessionexample.user.Role;
import com.sphong.sessionexample.user.SessionUser;
import com.sphong.sessionexample.user.User;
import com.sphong.sessionexample.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public Long save(SignInRequestDto requestDto) {
        userRepository.findByUserId(requestDto.getUserId());
        User user = User.builder().userId(requestDto.getUserId()).userPw(requestDto.getUserPw()).role(Role.USER).build();
        SessionUser sessionUser = new SessionUser(user);
        httpSession.setAttribute("user",sessionUser);
        return userRepository.save(user).getId();
    }
}
