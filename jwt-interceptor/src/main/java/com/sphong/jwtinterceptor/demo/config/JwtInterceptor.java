package com.sphong.jwtinterceptor.demo.config;

import com.sphong.jwtinterceptor.demo.config.jwtUtil.JwtUtil;
import com.sphong.jwtinterceptor.demo.web.domain.user.User;
import com.sphong.jwtinterceptor.demo.web.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = userRepository.findById(Long.parseLong(request.getHeader("userId"))).orElseThrow(()->new IllegalArgumentException("없는 유저"));
        String givenToken = request.getHeader("token");
        verifyToken(user.getToken(), givenToken);
        return true;
    }

    private void verifyToken(String givenToken, String userToken) throws IllegalAccessException {
        if (givenToken.equals(userToken)) {
            throw new IllegalAccessException("사용자 Token 불일치");
        }

    }
}
