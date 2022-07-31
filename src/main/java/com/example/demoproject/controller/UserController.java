package com.example.demoproject.controller;

import com.example.demoproject.domain.User;
import com.example.demoproject.server.UserService;
import com.example.demoproject.server.impl.UserServiceImpl;
import com.example.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

//    @PostMapping("/login")
//    public JsonData login(String username, String password) {
//        System.out.println("username: " + username+ " password: " + password);
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    public UserService userService;

    @PostMapping("/login")
    public JsonData login(@RequestBody User user) {

        System.out.println("user: " + user);

        String token = userService.login(user.getUsername(), user.getPassword());
        System.out.println("token_1: " + token);
        return token != null ? JsonData.buildSuccess(token) : JsonData.buildError("登录失败");
    }


    @GetMapping("/list")
    public JsonData listUser() {
        return JsonData.buildSuccess(userService.listUser());
    }


}
