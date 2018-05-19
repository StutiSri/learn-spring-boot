package com.learn.springboot.api.actuator.dummy;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Endpoint(id="dummy")
@Component
public class DummyEndpoint {
    @ReadOperation
    public Map<String, Object> invoke() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("message", "Its Dummy. You Dummy!");
        return messages;
    }
}
