package com.learn.springboot.api.actuator.health;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class HealthCheck implements HealthIndicator {
    private List<String> downstreamServiceUrls;

    private RestTemplate restTemplate;

    @Autowired
    public HealthCheck(RestTemplate restTemplate,
                                     @Value("#{'${downstream.service.urls}'.split(',')}")
                                             List<String> downstreamServiceUrls) {
        this.restTemplate = restTemplate;
        this.downstreamServiceUrls = downstreamServiceUrls;
    }

    @Override
    public Health health() {
        JsonNode healthResponse;
        Health.Builder healthBuilder = Health.up();
        for (String downstreamServiceUrl : downstreamServiceUrls) {
            try{
                healthResponse = restTemplate.getForObject(downstreamServiceUrl + "/health", JsonNode.class);
                String healthStatus = healthResponse.get("status").textValue();
                if(healthStatus.equalsIgnoreCase("down")){
                    healthBuilder = healthBuilder.down();
                }
                healthBuilder = healthBuilder.withDetail(downstreamServiceUrl, healthStatus);
            }catch (Exception e){
                healthBuilder = healthBuilder
                        .down()
                        .withDetail(downstreamServiceUrl, "DOWN");
            }
        }
        return healthBuilder.build();
    }
}
