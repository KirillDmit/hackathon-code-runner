package com.example.hackathon_code_runner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hackathon_code_runner.dto.GetHobbiesModel;
import com.example.hackathon_code_runner.storage.HobbiesRepository;

@Controller
public class HobbiesController {

    @PostMapping("/hobbies/set")
    public ResponseEntity<Void> setHobbiesForUser(){
        return ResponseEntity.ok().build();
    }

    @PostMapping("/hobbies/get")
    public ResponseEntity<String[]> getHobbiesForUser(GetHobbiesModel model){
        var hobbies = HobbiesRepository.getInstance().getHobbiesFor(model.user_id).toArray(new String[0]);
        return ResponseEntity.ok(hobbies);
    }
}
