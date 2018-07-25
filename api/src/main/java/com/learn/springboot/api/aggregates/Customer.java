package com.learn.springboot.api.aggregates;

import com.learn.springboot.api.command.RegisterCustomerCommand;
import com.learn.springboot.api.event.CustomerRegisteredEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Customer {
    @AggregateIdentifier
    private String customerId;
    private String email;
    private String password;
    private String name;

    //framework required
    public Customer() {
    }

    @CommandHandler
    public Customer(RegisterCustomerCommand command) {
        apply(new CustomerRegisteredEvent(command.getCustomerId(), command.getName(), command.getEmail(), command.getPassword()));
    }

    @EventHandler
    public void on(CustomerRegisteredEvent event) {
        customerId = event.getCustomerId();
        email = event.getEmail();
        password = event.getPassword();
        name = event.getName();
    }
}
