package com.consumer.kafka.infrastructure.entrypoints.listener;

import com.consumer.kafka.domain.UseCase;
import com.consumer.kafka.infrastructure.entrypoints.listener.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Configuration
public class EventListener {

    private final UseCase useCase;

    public EventListener(UseCase useCase) {
        this.useCase = useCase;
    }

    @KafkaListener(groupId = "group1", topics = "messages", containerFactory = "consumer")
    public void eventListener(Event event) {
        log.info("Event received: {}", event.getMessage());
        useCase.saveMessage(event);
    }
}
