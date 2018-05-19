package com.learn.springboot.api.actuator.health;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HealthCheckTest {
    @Mock
    private RestTemplate restTemplate;

    @Mock
    private JsonNode jsonNode;

    @Mock
    private JsonNode jsonNodeWithUpValue;

    @Mock
    private JsonNode jsonNodeWithDownValue;

    private HealthCheck downStreamHealthIndicator;

    @Before
    public void setUp() {
        ArrayList<String> downStreamServiceUrls = new ArrayList<>();
        downStreamServiceUrls.add("url1");
        downStreamServiceUrls.add("url2");

        when(jsonNodeWithUpValue.textValue()).thenReturn("UP");
        when(jsonNodeWithDownValue.textValue()).thenReturn("DOWN");

        downStreamHealthIndicator = new HealthCheck(restTemplate, downStreamServiceUrls);
    }

    @Test
    public void shouldReturnStatusAsUpWhenAllDownStreamServicesAreHealthy() {
        when(jsonNode.get("status"))
                .thenReturn(jsonNodeWithUpValue)
                .thenReturn(jsonNodeWithUpValue);

        when(restTemplate.getForObject("url1/health", JsonNode.class)).thenReturn(jsonNode);
        when(restTemplate.getForObject("url2/health", JsonNode.class)).thenReturn(jsonNode);

        Health expectedHealthStatus =
                Health.up()
                        .withDetail("url1", "UP")
                        .withDetail("url2", "UP")
                        .build();

        assertEquals(expectedHealthStatus,downStreamHealthIndicator.health());
    }

    @Test
    public void shouldReturnStatusAsUpWhenAnyOneDownStreamServiceIsUnhealthy() {
        when(jsonNode.get("status"))
                .thenReturn(jsonNodeWithUpValue)
                .thenReturn(jsonNodeWithDownValue);

        when(restTemplate.getForObject("url1/health", JsonNode.class)).thenReturn(jsonNode);
        when(restTemplate.getForObject("url2/health", JsonNode.class)).thenReturn(jsonNode);

        Health expectedHealthStatus =
                Health.down()
                        .withDetail("url1", "UP")
                        .withDetail("url2", "DOWN")
                        .build();

        assertEquals(expectedHealthStatus,downStreamHealthIndicator.health());
    }
}