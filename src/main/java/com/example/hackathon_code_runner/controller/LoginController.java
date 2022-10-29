package com.example.hackathon_code_runner.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping
    public String login(){
        return "login_page!";
    }

    @PostMapping(value = "/auth")
    public String authenticate(Token token){
        if(loginService.authenticate(loginForm)){
            logger.info("login OK redirect to book shelf");
            return "redirect:/home";
        }
        else {
            logger.info("login FAIL redirect back to login");
            return "redirect:/form";
        }
    }
}
