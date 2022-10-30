package com.example.hackathon_code_runner.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import com.example.hackathon_code_runner.dao.*;

public class UserStorage {

    private static UserStorage instance;
    private HashMap<UUID, User> users;
    private Integer iterator;

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

    public User getUserById(Integer id){
        var user = users.values().stream().filter(u -> u.id == id).findFirst();
        return user.isPresent() ? user.get() : null;
    }

    public User setUser(User user) throws Exception {
        var oldUser = users.values().stream().filter(u -> u.id == user.id).findFirst();
        if (oldUser.isPresent()){
            user.private_id = oldUser.get().private_id;
            users.put(oldUser.get().private_id, user);
            return user;
        }
        user.private_id = UUID.randomUUID();
        user.id = ++iterator;
        users.put(user.private_id, user);
        return user;
    }
}
