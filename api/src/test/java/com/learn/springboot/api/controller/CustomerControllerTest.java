package com.learn.springboot.api.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldAcceptCustomerRegistrationRequest() throws Exception {
        CustomerRegistrationRequestBody customerRegistrationRequestBody =
                new CustomerRegistrationRequestBody.CustomerRegistrationRequestBodyBuilder()
                .buildWithUsername("someUserName")
                .buildWithPassword("somePassword")
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/customer/register", customerRegistrationRequestBody))
                .andExpect(status().isAccepted());
    }
}