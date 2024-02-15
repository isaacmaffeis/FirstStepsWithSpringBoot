package com.isaacmaffeis.firststepswithspringboot.services.impl;

import com.isaacmaffeis.firststepswithspringboot.services.BluePrinter;
import com.isaacmaffeis.firststepswithspringboot.services.ColourPrinter;
import com.isaacmaffeis.firststepswithspringboot.services.RedPrinter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class ColourPrinterImpl implements ColourPrinter {

    BluePrinter bluePrinter;
    RedPrinter redPrinter;

    public ColourPrinterImpl(BluePrinter bluePrinter, RedPrinter redPrinter) {
        this.bluePrinter = bluePrinter;
        this.redPrinter = redPrinter;
    }

    @Override
    public String print() {
        return bluePrinter.print() + ", " + redPrinter.print();
    }

}
