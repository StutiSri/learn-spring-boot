package com.learn.springboot.api.controller;

import com.learn.springboot.api.callback.MappableCommandCallback;
import com.learn.springboot.api.command.RegisterCustomerCommand;
import com.learn.springboot.api.vo.CustomerCreatedResponse;
import com.learn.springboot.api.vo.CustomerRegistrationRequestBody;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CustomerController {

    private CommandBus commandBus;

    @Autowired
    public CustomerController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @RequestMapping(value = "/customer/register", method = POST)
    public Object registerCustomer(CustomerRegistrationRequestBody customerRegistrationRequestBody){

        String customerId = UUID.randomUUID().toString();

        MappableCommandCallback callback = new MappableCommandCallback(input -> new CustomerCreatedResponse(customerId));

        commandBus.dispatch(asCommandMessage(
                new RegisterCustomerCommand(customerId,
                customerRegistrationRequestBody.getEmail(),
                customerRegistrationRequestBody.getPassword(),
                customerRegistrationRequestBody.getName())), callback);

        return callback;
    }
}
