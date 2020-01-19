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

    public UserResponseDto findUserByMenu(String menu) {
        System.out.println(menu);
        User user = userRepository.findByMenu(menu).orElseThrow(() -> new IllegalArgumentException("User has test menu doesn't Exist"));
        return new UserResponseDto(user.getUserName(),user.getLocation());
    }
}
