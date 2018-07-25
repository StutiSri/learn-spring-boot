package com.learn.springboot.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springboot.api.vo.CustomerRegistrationRequestBody;
import org.axonframework.commandhandling.CommandBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CommandBus commandGateway;

    @Before
    public void setUp(){
        CustomerController customerController = new CustomerController(commandGateway);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void shouldAcceptCustomerRegistrationRequest() throws Exception {
        CustomerRegistrationRequestBody customerRegistrationRequestBody =
                new CustomerRegistrationRequestBody.CustomerRegistrationRequestBodyBuilder()
                .buildWithEmail("someEmail")
                .buildWithPassword("somePassword")
                .buildWithName("someName")
                .build();
       mockMvc.perform(MockMvcRequestBuilders
               .post("/customer/register", new ObjectMapper().writeValueAsString(customerRegistrationRequestBody)))
                .andExpect(status().isOk());
    }
}