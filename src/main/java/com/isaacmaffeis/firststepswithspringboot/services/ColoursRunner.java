package com.isaacmaffeis.firststepswithspringboot.services;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Log
public class ColoursRunner implements CommandLineRunner {

    ColourPrinter colourPrinter;

    public ColoursRunner(ColourPrinter colourPrinter) {
        this.colourPrinter = colourPrinter;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info(colourPrinter.print());
    }
}
