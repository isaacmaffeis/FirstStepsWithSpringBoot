package com.isaacmaffeis.firststepswithspringboot.services.impl;

import com.isaacmaffeis.firststepswithspringboot.services.BluePrinter;
import org.springframework.stereotype.Service;

@Service
public class ItalianBluePrinter implements BluePrinter {
    @Override
    public String print() {
        return "blu";
    }
}
