package com.example.hackathon_code_runner.service;


import com.example.hackathon_code_runner.models.ChatMessage;
import com.example.hackathon_code_runner.models.MessageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Update;
import com.example.hackathon_code_runner.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired private ChatMessageRepository repository;
    @Autowired private ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        repository.save(chatMessage);
        return chatMessage;
    }

    public long countNewMessages(String senderId, String recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);

        var messages =
                chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());

        if(messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }

        return messages;
    }

    public ChatMessage findById(String id) throws Exception {
        return repository
                .findById(id)
                .map(chatMessage -> {
                    return repository.save(chatMessage);
                })
                .orElseThrow(() ->
                        new Exception("can't find message (" + id + ")"));
    }

    public void updateStatuses(String senderId, String recipientId, MessageStatus status) {
        /*Query query = new Query(
                Criteria
                        .where("senderId").is(senderId)
                        .and("recipientId").is(recipientId));*/
        Update update = Update.update("status", status);
    }
}