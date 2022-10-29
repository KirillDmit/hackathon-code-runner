package com.example.hackathon_code_runner.dto;

import java.util.Calendar;
import java.util.UUID;

public class Token {
    private Calendar cal;
    String token = UUID.randomUUID().toString().toUpperCase()
            + "|" + "userid" + "|"
            + cal.getTimeInMillis();
}
