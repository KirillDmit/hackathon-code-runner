package com.example.hackathon_code_runner.dto;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.UUID;

public class Token {
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    public boolean equals(Token token) {
        return this.toString().equals(token.toString());
    }
}
