package com.sphong.jwtinterceptor.demo.config.jwtUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtUtilImpl implements JwtUtil {
    private final String TEST_KEY = "TEST";
    private final Date EXPIRED_TIME = new Date(System.currentTimeMillis() + 1000);
    private final String ISUSER = "HSP";

    @Override
    public String createToken() throws UnsupportedEncodingException {
        return JWT.create()
                .withIssuer(ISUSER)
                .withExpiresAt(EXPIRED_TIME)
                .sign(Algorithm.HMAC256(TEST_KEY));
    }

    @Override
    public void verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(TEST_KEY))
                                    .withIssuer(ISUSER)
                                    .build();
    }
}
