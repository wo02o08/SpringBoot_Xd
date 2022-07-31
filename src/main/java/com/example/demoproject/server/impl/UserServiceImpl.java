package com.example.demoproject.server.impl;

import com.example.demoproject.domain.User;
import com.example.demoproject.mapper.UserMapper;
import com.example.demoproject.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    //分布式 放redis
    public static final Map<String, User> session = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String password) {
        User user = userMapper.login(username, password);
        if(user != null) {
            String token = UUID.randomUUID().toString();
            System.out.println("token_0: " + token);
            session.put(token, user);
            return token;
        }
        return null;
    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }

}
