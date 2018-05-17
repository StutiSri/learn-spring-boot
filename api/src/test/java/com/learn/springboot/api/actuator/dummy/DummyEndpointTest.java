package com.learn.springboot.api.actuator.dummy;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DummyEndpointTest {

    private DummyEndpoint dummyEndPoint;

    @Before
    public void setUp() throws Exception {
        dummyEndPoint = new DummyEndpoint();
    }

    @Test
    public void shouldReturnResultOnInvocation() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("message", "Its Dummy. You Dummy!");

        assertEquals("dummy", dummyEndPoint.getId());
        assertEquals(true, dummyEndPoint.isEnabled());
        assertEquals(false, dummyEndPoint.isSensitive());
        assertEquals(messages, dummyEndPoint.invoke());
    }
}