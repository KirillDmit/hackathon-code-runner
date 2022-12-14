package com.example.hackathon_code_runner.service;

import com.example.hackathon_code_runner.dto.LoginForm;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("singleTransactionsService")
public class LoginService {

    private Logger logger = Logger.getLogger(String.valueOf(LoginService.class));

    public boolean authenticate(LoginForm loginForm) {
        logger.info("try auth with user-form: " + loginForm);
        return loginForm.getUsername().equals("root") && loginForm.getPassword().equals("123");
    }
}
