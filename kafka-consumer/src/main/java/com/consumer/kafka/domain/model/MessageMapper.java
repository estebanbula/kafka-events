package com.consumer.kafka.domain.model;

import com.consumer.kafka.infrastructure.adapters.database.entity.MessageEntity;

public class MessageMapper {

    public static Message map(MessageEntity messageEntity) {
        return Message.builder()
                .id(messageEntity.getId())
                .message(messageEntity.getMessage())
                .build();
    }
}
