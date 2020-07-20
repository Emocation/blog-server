package com.my.blog.serve.util;

import com.auth0.jwt.JWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jiangkaibing
 * @Date: Create in 20:27 2020/7/19
 */
public class TokenUtil {
    public static String getTokenUserId() {
        String token = getRequest().getHeader("token");
        String username = JWT.decode(token).getAudience().get(0);
        return username;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
