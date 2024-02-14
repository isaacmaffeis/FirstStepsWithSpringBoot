package com.isaacmaffeis.firststepswithspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello") // path must be in lowercase
    public String helloWorld(){
        return "Hello World!";
    }

}
