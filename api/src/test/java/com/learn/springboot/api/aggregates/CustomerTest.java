package com.learn.springboot.api.aggregates;

import com.learn.springboot.api.command.RegisterCustomerCommand;
import com.learn.springboot.api.event.CustomerRegisteredEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;


public class CustomerTest {
    private FixtureConfiguration<Customer> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(Customer.class);
    }

    @Test
    public void shouldEmitCustomerRegisteredEventWhenCustomerIsRegistered() {
        String customerId = "some-id";
        String name = "someName";
        String email = "someEmail";
        String password = "somePassword";

        fixture.given()
                .when(new RegisterCustomerCommand(customerId, email, password, name))
                .expectEvents(new CustomerRegisteredEvent(customerId, name, email, password));

    }
}