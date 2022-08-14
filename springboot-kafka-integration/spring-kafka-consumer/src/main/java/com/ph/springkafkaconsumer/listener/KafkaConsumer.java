package com.ph.springkafkaconsumer.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ph.springkafkaconsumer.dto.OrderDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @Autowired
    ObjectMapper mapper;

    @KafkaListener(topics = "order_topic",groupId = "group_id")
    public void consumesOrder(String message) throws JsonProcessingException {
        System.out.println("Message : "+message);
        OrderDetailsDto orderDetails = mapper.readValue(message, OrderDetailsDto.class);
    }
}
