package com.my.blog.serve.service;

import com.my.blog.serve.entity.ResultMessage;
import com.my.blog.serve.entity.UserInfo;
import com.my.blog.serve.entity.UserInfoExample;
import com.my.blog.serve.mapper.UserInfoMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminLoginService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo selectByExample(String userName, String password) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        if (!"".equals(userName))
            criteria.andUsernameEqualTo(userName);
        if (!"".equals(password))
            criteria.andPasswordEqualTo(password);
        UserInfo userInfo = userInfoMapper.confirmUser(userName);
        if (userInfo != null){
            if (password.equals(userInfo.getPassword())){
                return userInfo;
            }
        }
        return null;

    }
    public UserInfo getUser(String username){
        return userInfoMapper.confirmUser(username);
    }
    public Integer insertUser(UserInfo userInfo){
        return userInfoMapper.insertSelective(userInfo);
    }
}
