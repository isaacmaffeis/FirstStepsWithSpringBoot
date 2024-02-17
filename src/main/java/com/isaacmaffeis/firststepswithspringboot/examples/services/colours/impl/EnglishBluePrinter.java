package com.isaacmaffeis.firststepswithspringboot.examples.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.services.colours.BluePrinter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class EnglishBluePrinter implements BluePrinter {

    @Override
    public String print() {
        return "blue";
    }

}
