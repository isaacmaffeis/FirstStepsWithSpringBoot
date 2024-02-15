package com.isaacmaffeis.firststepswithspringboot.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.services.colours.BluePrinter;
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
