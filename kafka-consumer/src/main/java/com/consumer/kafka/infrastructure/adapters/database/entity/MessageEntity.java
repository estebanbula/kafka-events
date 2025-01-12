package com.consumer.kafka.infrastructure.adapters.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "message")
@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
}
