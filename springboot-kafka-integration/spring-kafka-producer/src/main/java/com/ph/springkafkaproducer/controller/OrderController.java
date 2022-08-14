package com.ph.springkafkaproducer.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ph.springkafkaproducer.dto.OrderDetails;
import com.ph.springkafkaproducer.service.KafkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private KafkaServiceImpl kafkaService;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDetails> createOrder(@RequestBody OrderDetails orderDetails){
        String message = null;
        try {
            message = mapper.writeValueAsString(orderDetails);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        kafkaService.sendMessage(message);
        return ResponseEntity.ok(orderDetails);
    }

    @GetMapping("/")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok("{status:UP}");
    }
}
