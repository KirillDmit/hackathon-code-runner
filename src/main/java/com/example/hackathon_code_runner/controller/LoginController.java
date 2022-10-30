package com.example.hackathon_code_runner.controller;

import com.example.hackathon_code_runner.dto.Token;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Logger logger = Logger.getLogger(String.valueOf(LoginController.class));
    private Token token;

    @GetMapping
    public String login(){
        return "login_page!";
    }

    @PostMapping(value = "/auth")
    public String authenticate(Token token){
        if(token.equals(token)){
            logger.info("login OK redirect to home");
            return "redirect:/home";
        }
        else {
            logger.info("login FAIL redirect to form");
            return "redirect:/form";
        }
    }
}
