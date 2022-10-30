package com.example.hackathon_code_runner.controller;

import com.example.hackathon_code_runner.dao.User;
import com.example.hackathon_code_runner.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
@CrossOrigin
public class UsersController {

    @GetMapping("/registration/")
    public ResponseEntity<Void> register(@RequestBody User user) {
        System.out.println("handling register user request: " + user.name);
        try {
            UserStorage.getInstance().setUser(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/fetchAllUsers")
    public Collection<User> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }
}