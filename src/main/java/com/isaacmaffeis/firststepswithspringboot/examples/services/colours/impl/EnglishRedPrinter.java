package com.isaacmaffeis.firststepswithspringboot.examples.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.examples.services.colours.RedPrinter;
import org.springframework.stereotype.Service;

@Service
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print() {
        return "red";
    }

}
