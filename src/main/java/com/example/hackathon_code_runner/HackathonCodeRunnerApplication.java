package com.example.hackathon_code_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HackathonCodeRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackathonCodeRunnerApplication.class, args);
    }

}
