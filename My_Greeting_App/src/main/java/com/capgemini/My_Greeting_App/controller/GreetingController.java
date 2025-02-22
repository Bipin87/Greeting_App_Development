package com.capgemini.My_Greeting_App.controller;

import com.capgemini.My_Greeting_App.data_transfer_object.Greeting;
import org.springframework.web.bind.annotation.*;



// GreetingController handles different HTTP methods and returns JSON responses
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET request to greet and send json data
    @GetMapping
    public Greeting sayHello(){
        return new Greeting("Hello From BridgeLab");
    }

    // POST request to greet and send json data
    @PostMapping("/create")
    public Greeting sayHelloPost(@RequestBody Greeting greet){
        return new Greeting(greet.getMessage());
    }

    // PUT request to update the greet message
    @PutMapping("/update")
    public Greeting updateGreeting(@RequestBody Greeting greet){
        return new Greeting(greet.getMessage() + " message updated");
    }

    // DELETE request to delete the greet message
    @DeleteMapping("/delete")
    public Greeting deleteGreetingMessage(){
        return new Greeting("Message deleted successfully");
    }
}