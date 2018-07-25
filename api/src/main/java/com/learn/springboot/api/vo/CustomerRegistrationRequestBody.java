package com.learn.springboot.api.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerRegistrationRequestBody {

    @Valid
    @NotNull
    @NotBlank
    private String name;

    @Valid
    @NotNull
    @NotBlank
    private String password;

    @Valid
    @NotNull
    @NotBlank
    private String email;

    private String Ssn;

    public CustomerRegistrationRequestBody() {
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return Ssn;
    }

    public CustomerRegistrationRequestBody(CustomerRegistrationRequestBodyBuilder customerRegistrationRequestBodyBuilder) {
        email = customerRegistrationRequestBodyBuilder.email;
        password = customerRegistrationRequestBodyBuilder.password;
        name = customerRegistrationRequestBodyBuilder.name;
    }

    public static class CustomerRegistrationRequestBodyBuilder{
        private String email;
        private String password;
        private String name;

        public CustomerRegistrationRequestBodyBuilder buildWithEmail(String value){
            this.email = value;
            return this;
        }

        public CustomerRegistrationRequestBodyBuilder buildWithPassword(String value){
            this.password = value;
            return this;
        }

        public CustomerRegistrationRequestBodyBuilder buildWithName(String value){
            this.name = value;
            return this;
        }



        public CustomerRegistrationRequestBody build(){
            return new CustomerRegistrationRequestBody(this);
        }

    }
}
