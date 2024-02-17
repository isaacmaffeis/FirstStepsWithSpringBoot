package com.isaacmaffeis.firststepswithspringboot.examples.jackson.controllers;

import com.isaacmaffeis.firststepswithspringboot.examples.jackson.domain.Book_B;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class BookController_B {
    @GetMapping(path = "/books")
    public Book_B retrieveBook() {
        return Book_B.builder()
                .isbn("978-0-13-478627-5")
                .title("The Enigma of Eternity")
                .author("Aria Montgomery")
                .yearPublished("2005")
                .build();
    }

    @PostMapping(path = "/books")
    public Book_B createBook(@RequestBody final Book_B bookB) {
        log.info("Got book: " + bookB.toString());
        return bookB;
    }
}