package com.learn.springboot.api.actuator.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    private HealthStatus healthStatus;

    @Autowired
    public HealthCheck(HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    @Override
    public Health health() {
        int errorCode = healthStatus.checkHealth();
        if(errorCode != 0){
            return Health
                    .down()
                    .withDetail("Error Code", errorCode)
                    .build();
        }
        return Health.up().build();
    }


}
