package com.storage.FileManagementStorage.Controller;

import com.storage.FileManagementStorage.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, User> users;

    public UserController() {
        users = new HashMap<>();
    }

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}