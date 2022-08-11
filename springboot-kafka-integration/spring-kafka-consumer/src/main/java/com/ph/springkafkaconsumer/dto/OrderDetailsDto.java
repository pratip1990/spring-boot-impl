package com.ph.springkafkaconsumer.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailsDto {
    private Long orderId;
    private Long customerId;
    private Long restaurantId;
}

