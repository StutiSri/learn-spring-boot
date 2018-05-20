package com.learn.springboot.api.controller;

public class CustomerRegistrationRequestBody {

    private String password;
    private String username;

    public CustomerRegistrationRequestBody() {
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public CustomerRegistrationRequestBody(CustomerRegistrationRequestBodyBuilder customerRegistrationRequestBodyBuilder) {
        username = customerRegistrationRequestBodyBuilder.getUsername();
        password = customerRegistrationRequestBodyBuilder.getPassword();
    }

    public static class CustomerRegistrationRequestBodyBuilder{
        private String username;
        private String password;

        public CustomerRegistrationRequestBodyBuilder buildWithUsername(String username){
            this.username = username;
            return this;
        }
        public CustomerRegistrationRequestBodyBuilder buildWithPassword(String password){
            this.password = password;
            return this;
        }
        public CustomerRegistrationRequestBody build(){
            return new CustomerRegistrationRequestBody(this);
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
