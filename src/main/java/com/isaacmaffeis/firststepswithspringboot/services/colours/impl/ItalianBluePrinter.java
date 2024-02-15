package com.isaacmaffeis.firststepswithspringboot.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.services.colours.BluePrinter;
import org.springframework.stereotype.Service;

@Service
public class ItalianBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "blu";
    }
}
