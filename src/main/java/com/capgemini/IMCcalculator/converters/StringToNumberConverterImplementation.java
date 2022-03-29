package com.capgemini.IMCcalculator.converters;

import org.springframework.stereotype.Component;

@Component
public class StringToNumberConverterImplementation implements  StringToNumberConverter{
    @Override
    public int convertToNumber(String stringToNumber) {
        return Integer.parseInt(stringToNumber);
    }

    public StringToNumberConverterImplementation() {
    }
}
