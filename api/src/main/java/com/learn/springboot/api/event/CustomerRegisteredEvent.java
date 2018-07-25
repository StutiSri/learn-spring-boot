package com.learn.springboot.api.event;


public class CustomerRegisteredEvent {

    private final String customerId;
    private final String name;
    private final String email;
    private final String password;

    public CustomerRegisteredEvent(String customerId, String name, String email, String password) {

        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
