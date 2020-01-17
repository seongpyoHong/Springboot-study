package com.sphong.jwtinterceptor.demo.web.service;

import com.sphong.jwtinterceptor.demo.config.jwtUtil.JwtUtil;
import com.sphong.jwtinterceptor.demo.web.domain.user.User;
import com.sphong.jwtinterceptor.demo.web.domain.user.UserRepository;
import com.sphong.jwtinterceptor.demo.web.dto.SignInResponseDto;
import com.sphong.jwtinterceptor.demo.web.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JwtUtil jwtutil;
    private final UserRepository userRepository;

    public void signUp(SignupRequestDto request) throws IllegalAccessException {
        verifyDuplicateUser(request.getUserEmail());
        userRepository.save(User.builder().userEmail(request.getUserEmail()).userPw(request.getUserPw()).token(jwtutil.createToken()).build());

    }

    private void verifyDuplicateUser(String userEmail) throws IllegalAccessException {
        if (userRepository.findByUserEmail(userEmail).isPresent()) {
            throw new IllegalAccessException("중복 유저");
        }
    }

    public SignInResponseDto signIn(SignupRequestDto request) throws IllegalAccessException {
        User user = userRepository.findByUserEmail(request.getUserEmail()).orElseThrow(() -> new IllegalArgumentException("없는 유저"));
        if (!request.getUserPw().equals(user.getUserPw())) {
            throw new IllegalAccessException("비밀번호 불일치");
        }
        return new SignInResponseDto(user.getToken());
    }
}
