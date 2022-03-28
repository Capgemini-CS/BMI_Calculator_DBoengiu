package com.capgemini.IMCcalculator.converters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToNumberConverterImplementationTest {

    StringToNumberConverterImplementation converter = new StringToNumberConverterImplementation();

    @Test
    void convertToNumber() {
        assertEquals(5, converter.convertToNumber("5"));
    }
}