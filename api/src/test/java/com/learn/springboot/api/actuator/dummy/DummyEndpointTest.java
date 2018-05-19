package com.learn.springboot.api.actuator.dummy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DummyEndpointTest {

    private DummyEndpoint dummyEndPoint;

    @Before
    public void setUp() {
        dummyEndPoint = new DummyEndpoint();
    }

    @Test
    public void shouldReturnResultOnInvocation() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("message", "Its Dummy. You Dummy!");
        assertEquals(messages, dummyEndPoint.invoke());
    }
}