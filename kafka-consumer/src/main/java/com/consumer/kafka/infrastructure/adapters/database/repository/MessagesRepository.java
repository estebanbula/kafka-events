package com.consumer.kafka.infrastructure.adapters.database.repository;

import com.consumer.kafka.infrastructure.adapters.database.entity.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<MessageEntity, String> {

}
