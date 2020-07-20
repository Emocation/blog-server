package com.my.blog.serve.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.my.blog.serve.entity.UserInfo;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: jiangkaibing
 * @Date: Create in 20:16 2020/7/19
 */
@Service
public class TokenService {
    public String getToken(UserInfo userInfo) {
        Date now = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;
        Date end = new Date(currentTime);
        String token = JWT.create().withAudience(userInfo.getUsername()).withIssuedAt(now).withExpiresAt(end)
                .sign(Algorithm.HMAC256(userInfo.getPassword()));
        return token;
    }
}
