package com.learn.springboot.api.health;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.actuate.health.Status.DOWN;
import static org.springframework.boot.actuate.health.Status.UP;

@RunWith(MockitoJUnitRunner.class)
public class HealthCheckTest {

    @Mock
    HealthStatus healthStatus;

    @Test
    public void shouldReturnUnhealthyWhenHealthIsDown() {
        HealthCheck healthCheck = new HealthCheck(healthStatus);
        when(healthStatus.checkHealth()).thenReturn(1);

        Map errorDetails = new HashMap();
        errorDetails.put("Error Code", 1);

        assertEquals(healthCheck.health().getStatus(), DOWN);
        assertEquals(healthCheck.health().getDetails(), errorDetails);
    }

    @Test
    public void shouldReturnHealthyWhenHealthIsUp() {
        HealthCheck healthCheck = new HealthCheck(healthStatus);
        when(healthStatus.checkHealth()).thenReturn(0);

        assertEquals(healthCheck.health().getStatus(), UP);
        assertEquals(healthCheck.health().getDetails(), emptyMap());
    }
}