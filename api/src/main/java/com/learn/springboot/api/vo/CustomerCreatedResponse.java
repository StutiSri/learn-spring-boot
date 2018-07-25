package com.learn.springboot.api.vo;

public class CustomerCreatedResponse {
    private String customerId;

    public CustomerCreatedResponse() {
    }

    public CustomerCreatedResponse(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
