package com.capgemini.IMCcalculator.converters;

import org.springframework.stereotype.Component;

@Component
public class StringToNumberConverterImplementation implements  StringToNumberConverter{
    @Override
    public double convertToNumber(String stringToNumber) {
        return Double.parseDouble(stringToNumber);
    }

    public StringToNumberConverterImplementation() {
    }
}
