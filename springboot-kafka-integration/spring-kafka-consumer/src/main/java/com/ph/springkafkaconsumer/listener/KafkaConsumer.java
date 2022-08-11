package com.ph.springkafkaconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @KafkaListener(topics = "order_topic",groupId = "group_id")
    public void consumesOrder(String message){
        System.out.println("message = " + message);
    }
}
