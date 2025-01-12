package com.consumer.kafka.infrastructure.entrypoints.web;

import com.consumer.kafka.domain.UseCase;
import com.consumer.kafka.domain.model.Message;
import com.consumer.kafka.infrastructure.adapters.database.repository.MessagesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    private final UseCase useCase;

    public MessageController(UseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping(value = "/all-messages")
    public List<Message> getAllMessages() {
        return ResponseEntity.ok().body(useCase.getMessages()).getBody();
    }
}
