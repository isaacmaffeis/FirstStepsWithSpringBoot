package com.isaacmaffeis.firststepswithspringboot.services.colours.impl;

import com.isaacmaffeis.firststepswithspringboot.services.colours.BluePrinter;
import com.isaacmaffeis.firststepswithspringboot.services.colours.ColourPrinter;
import com.isaacmaffeis.firststepswithspringboot.services.colours.RedPrinter;
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
