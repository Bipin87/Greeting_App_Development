package com.capgemini.My_Greeting_App.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "Hello World";
    }

    // Method to return the hello world using first name and last name
    public String customGreetingMessage(String firstName, String lastName){
        if(firstName != null && lastName != null){
            return "Hello " + firstName + " " + lastName + "!!";
        } else if (firstName != null) {
            return "Hello" + firstName + "!!";
        } else if (lastName != null) {
            return "Hello" + lastName + "!!";
        }else {
            return "Hello World";
        }
    }
}