package com.capgemini.My_Greeting_App.data_transfer_object;

public class Greeting {

    private String message;

    // Default constructor (required by JPA)
    public Greeting() {}

    public Greeting(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
