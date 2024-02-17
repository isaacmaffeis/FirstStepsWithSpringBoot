package com.isaacmaffeis.firststepswithspringboot.examples.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.services.colours.BluePrinter;
import org.springframework.stereotype.Service;

@Service
public class ItalianBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "blu";
    }
}
