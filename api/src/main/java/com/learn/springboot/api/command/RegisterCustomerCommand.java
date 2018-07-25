package com.learn.springboot.api.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class RegisterCustomerCommand {
    @TargetAggregateIdentifier
    private String customerId;
    private String email;
    private String password;
    private String name;

    public RegisterCustomerCommand(String customerId, String email, String password, String name) {
        this.customerId = customerId;
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
