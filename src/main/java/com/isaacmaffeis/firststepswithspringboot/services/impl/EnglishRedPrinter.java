package com.isaacmaffeis.firststepswithspringboot.services.impl;

import com.isaacmaffeis.firststepswithspringboot.services.RedPrinter;
import org.springframework.stereotype.Service;

@Service
public class EnglishRedPrinter implements RedPrinter {

    @Override
    public String print() {
        return "red";
    }

}
