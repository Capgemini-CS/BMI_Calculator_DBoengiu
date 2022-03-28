package com.capgemini.IMCcalculator.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidationImplementationTest {

    NumberValidationImplementation validation = new NumberValidationImplementation();

    @Test
    void isNotNumericThrowsException() {
        assertThrows(NumberFormatException.class, () -> validation.isNotNumeric("abc"));
    }


}