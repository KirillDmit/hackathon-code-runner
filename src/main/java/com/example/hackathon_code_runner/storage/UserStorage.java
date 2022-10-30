package com.example.hackathon_code_runner.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import com.example.hackathon_code_runner.dao.*;

public class UserStorage {

    private static UserStorage instance;
    private HashMap<UUID, User> users;

    private UserStorage() {
        users = new HashMap<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public void setUser(User user) throws Exception {
        if (users.values().stream().anyMatch(u -> u.id == user.id)) {
            throw new Exception("User aready exists with userName: " + user.name);
        }
        users.put(UUID.randomUUID(), user);
    }
}
