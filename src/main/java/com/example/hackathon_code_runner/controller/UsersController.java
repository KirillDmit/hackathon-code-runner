package com.example.hackathon_code_runner.controller;

import com.example.hackathon_code_runner.dao.User;
import com.example.hackathon_code_runner.storage.HobbiesRepository;
import com.example.hackathon_code_runner.storage.UserStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class UsersController {

    @GetMapping("/user/registration/")
    public ResponseEntity<User> register(@RequestBody User user) {
        System.out.println("handling register user request: " + user.name);
        try {
            return ResponseEntity.ok(UserStorage.getInstance().setUser(user));
        } catch (Exception e) {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/user/login/")
    public ResponseEntity<User> login(@RequestBody User user){
        try {
            return ResponseEntity.ok(UserStorage.getInstance().getUserById(user.id));
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ResponseEntity.ok(null);
    }

    @GetMapping("/fetchAllUsers")
    public Collection<User> fetchAll() {
        return UserStorage.getInstance().getUsers();
    }


    @GetMapping("/users/get-people-by-tag")
    public ResponseEntity<User[]> getPeopleByTag(@RequestParam String tag){
        var users = HobbiesRepository.getInstance().getUsersWithSimilarHobbie(tag);
        return ResponseEntity.ok(users);
    }
}