package com.learn.springboot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = GET)
    public String welcomeMessage(){
        return "Welcome to a galaxy far far away!!";
    }
}
