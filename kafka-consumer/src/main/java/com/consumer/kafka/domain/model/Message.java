package com.consumer.kafka.domain.model;

import lombok.*;

@Builder(toBuilder = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private Integer id;
    private String message;
}
