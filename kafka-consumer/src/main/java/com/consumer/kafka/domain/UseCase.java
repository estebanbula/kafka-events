package com.consumer.kafka.domain;

import com.consumer.kafka.domain.model.Message;
import com.consumer.kafka.domain.model.MessageMapper;
import com.consumer.kafka.infrastructure.adapters.database.entity.MessageEntity;
import com.consumer.kafka.infrastructure.adapters.database.repository.MessagesRepository;
import com.consumer.kafka.infrastructure.entrypoints.listener.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class UseCase {

    private final MessagesRepository messagesRepository;

    public UseCase(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public void saveMessage(Event event) {
        log.info("save event {}", event);
        messagesRepository.save(MessageEntity.builder()
                        .message(event.getMessage())
                .build());
    }

    public List<Message> getMessages() {
        List<Message> messageList = new ArrayList<>();
        messagesRepository.findAll().forEach(message -> messageList.add(MessageMapper.map(message)));
        return messageList;
    }
}
