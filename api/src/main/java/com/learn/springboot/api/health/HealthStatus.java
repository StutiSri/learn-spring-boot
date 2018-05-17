package com.learn.springboot.api.health;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HealthStatus {
    int checkHealth() {
        return new Random().nextInt(3);
    }
}
