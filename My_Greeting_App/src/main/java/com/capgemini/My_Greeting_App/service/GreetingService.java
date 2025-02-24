package com.capgemini.My_Greeting_App.service;

import com.capgemini.My_Greeting_App.entities.GreetingEntity;
import com.capgemini.My_Greeting_App.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;

    // Constructor-based Dependency Injection
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

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
    // Save Greeting Message
    public GreetingEntity saveGreeting(String message) {
        GreetingEntity greeting = new GreetingEntity(message);
        return greetingRepository.save(greeting);
    }

}