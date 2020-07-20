package com.my.blog.serve.controller;

import com.alibaba.fastjson.JSONObject;
import com.my.blog.serve.entity.ResultMessage;
import com.my.blog.serve.entity.UserInfo;
import com.my.blog.serve.service.AdminLoginService;
import com.my.blog.serve.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class AdminLoginControl {


    @Autowired
    private AdminLoginService adminLoginService;
    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public ResultMessage<UserInfo> adminLogin(@RequestBody Map<String, String> map , HttpServletResponse response) {
        String username = map.get("username");
        String password = map.get("password");
        UserInfo adminList = adminLoginService.selectByExample(username, password);
        if (adminList == null) {
            return new ResultMessage<>(403, "用户名面膜错误请重新登录", null);
        } else {
            String token = tokenService.getToken(adminList);
            Cookie cookie = new Cookie("token" ,token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ResultMessage<>(200, "success", adminList);
        }
    }

    @PostMapping("/signIn")
    public ResultMessage<UserInfo> signIn(@RequestBody UserInfo userInfo) {
        Integer insertIndex = adminLoginService.insertUser(userInfo);
        if (insertIndex.equals(0)){
            return new ResultMessage<>(400, "插入失败，重新输入", null);
        }
        return new ResultMessage<>(200, "success", userInfo);

    }
}
