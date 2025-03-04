package com.capgemini.My_Greeting_App.controller;

import com.capgemini.My_Greeting_App.data_transfer_object.UserDTO;
import com.capgemini.My_Greeting_App.entities.GreetingEntity;
import com.capgemini.My_Greeting_App.service.GreetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("greet/hello")
public class GreetingServiceController {
    // attribute
    private final GreetingService greetingService;

    public GreetingServiceController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping
    public String sayHello(){
        return greetingService.getGreetingMessage();
    }

    // GET request to greet with firstname and lastname
    @GetMapping("/data")
    public String greetWithFullName(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName){
        return greetingService.customGreetingMessage(firstName,lastName);
    }
    @PostMapping("/post")
    public String getCustomGreetingMessageWithPost(@RequestBody UserDTO user){
        return greetingService.customGreetingMessage(user.getFirstName(), user.getLastName());
    }

    // Save Greeting Message
    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public Optional<GreetingEntity> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GreetingEntity> updateGreeting(
            @PathVariable Long id, @RequestParam String message) {
        try {
            GreetingEntity updatedGreeting = greetingService.updateGreeting(id, message);
            return ResponseEntity.ok(updatedGreeting);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return ResponseEntity.noContent().build();
    }

}