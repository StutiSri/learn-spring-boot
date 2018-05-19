package com.learn.springboot.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WelcomeControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnWelcomeMessage() {
        ResponseEntity<String> response = testTemplate.getForEntity("http://localhost:" + port + "/welcome", String.class);
        assertEquals(OK, response.getStatusCode());
        assertEquals("Welcome to a galaxy far far away!!", response.getBody());
    }
}
