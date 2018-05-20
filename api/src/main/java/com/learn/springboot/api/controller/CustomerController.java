package com.learn.springboot.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CustomerController {
    @RequestMapping(value = "/customer/register", method = POST)
    public ResponseEntity registerCustomer(CustomerRegistrationRequestBody customerRegistrationRequestBody){
        return ResponseEntity
                .accepted()
                .build();
    }
}
