package com.learn.springboot.api.actuator.dummy;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DummyEndpoint implements Endpoint<Map<String,Object>> {
    @Override
    public String getId() {
        return "dummy";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Map<String, Object> invoke() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("message", "Its Dummy. You Dummy!");
        return messages;
    }
}
