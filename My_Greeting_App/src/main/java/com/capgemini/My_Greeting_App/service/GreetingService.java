package com.capgemini.My_Greeting_App.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "Hello World";
    }
}