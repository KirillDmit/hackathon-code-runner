package com.example.hackathon_code_runner.models;

import org.springframework.data.annotation.Id;

import java.sql.Date;

public class ChatMessage {

    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String senderName;
    private String recipientName;
    private String content;
    private Date timestamp;
    private MessageStatus status;
}
