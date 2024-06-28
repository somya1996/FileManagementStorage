package com.storage.FileManagementStorage;

import java.util.HashMap;
import java.util.Map;
public class UserAuthentication {
    private Map<String, String> users;

    public UserAuthentication() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}