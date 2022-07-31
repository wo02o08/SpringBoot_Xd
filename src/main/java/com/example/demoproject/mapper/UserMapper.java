package com.example.demoproject.mapper;

import com.example.demoproject.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {
    private static final Map<String, User> userMap = new HashMap<>();
    static {
        userMap.put("张三", new User(1, "张三", "123456"));
        userMap.put("李四", new User(2, "李四", "123456"));
        userMap.put("王五", new User(3, "王五", "123456"));
        userMap.put("赵六", new User(4, "赵六", "123456"));
        userMap.put("田七", new User(5, "田七", "123456"));
    }

    public User login(String username, String password) {
        User user = userMap.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public List<User> listUser() {
        return new ArrayList<>(userMap.values());
    }
}
