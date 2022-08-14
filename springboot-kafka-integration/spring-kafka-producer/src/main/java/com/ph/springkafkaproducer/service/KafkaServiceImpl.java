package com.ph.springkafkaproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name.producer}")
    private String topicName;

    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
        System.out.println("Message has sent successfully");
    }
}
