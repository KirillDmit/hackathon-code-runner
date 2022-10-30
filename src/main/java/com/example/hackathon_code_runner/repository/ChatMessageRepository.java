package com.example.hackathon_code_runner.repository;

import com.example.hackathon_code_runner.models.ChatMessage;
import com.example.hackathon_code_runner.models.MessageStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);
    List<ChatMessage> findByChatId(String chatId);
}
