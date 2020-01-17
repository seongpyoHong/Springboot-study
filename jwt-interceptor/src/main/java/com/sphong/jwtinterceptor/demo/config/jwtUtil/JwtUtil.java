package com.sphong.jwtinterceptor.demo.config.jwtUtil;

import java.io.UnsupportedEncodingException;

public interface JwtUtil {
    String createToken() throws UnsupportedEncodingException;
    void verifyToken(String token) throws UnsupportedEncodingException;
}
