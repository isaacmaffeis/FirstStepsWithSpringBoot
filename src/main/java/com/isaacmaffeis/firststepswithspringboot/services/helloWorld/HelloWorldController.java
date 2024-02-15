package com.isaacmaffeis.firststepswithspringboot.services.helloWorld;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class HelloWorldController implements CommandLineRunner {

    @GetMapping(path = "/hello") // path must be in lowercase
    public String helloWorld(){
        return "Hello World!";
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(
                String.format("Displayed \"Hello World!\" on path /hello")
        );
    }
}
