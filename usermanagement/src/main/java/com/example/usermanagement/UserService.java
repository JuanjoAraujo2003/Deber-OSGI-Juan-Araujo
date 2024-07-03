package com.example.usermanagement;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
