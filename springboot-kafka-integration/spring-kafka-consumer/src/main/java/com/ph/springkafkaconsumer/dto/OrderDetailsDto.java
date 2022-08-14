package com.ph.springkafkaconsumer.dto;

import lombok.Data;

import java.io.Serializable;

public class OrderDetailsDto implements Serializable{
    private static final long serialVersionUID = 1l;
    private Long orderId;
    private Long customerId;
    private Long providerId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }
}

