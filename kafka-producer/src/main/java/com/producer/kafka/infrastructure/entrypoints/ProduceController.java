package com.producer.kafka.infrastructure.entrypoints;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProduceController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProduceController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/produce")
    public ResponseEntity<String> produce(@RequestBody String payload) {
        kafkaTemplate.send("messages", payload).whenComplete((result,ex) -> {
            if(ex != null){
                log.error("Error sending message: {}",ex.getMessage());
            }
            log.info("Message sent successfully: {}",result.getProducerRecord().value());
            log.info("Partition {}, Offset {}", result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
        });
        return ResponseEntity.ok(payload);
    }
}
