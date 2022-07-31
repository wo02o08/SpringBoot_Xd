package com.example.demoproject.server;

import com.example.demoproject.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String password);

    List<User> listUser();
}
