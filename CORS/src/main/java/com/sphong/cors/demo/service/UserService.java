package com.sphong.cors.demo.service;

import com.sphong.cors.demo.domain.User;
import com.sphong.cors.demo.domain.UserRepository;
import com.sphong.cors.demo.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findByName(String name) {
        System.out.println(name);
        User user = userRepository.findByUserName(name).orElseThrow(() -> new IllegalArgumentException("User Not Exist"));
        return new UserResponseDto(user.getUserName());
    }
}
