package com.capgemini.IMCcalculator.validators;

import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanZeroValidationImplementationTest {

    GreaterThanZeroValidationImplementation greater = new GreaterThanZeroValidationImplementation();

    @Test
    void isGreaterThanZero() {
        assertThrows(NumberShouldBeGreaterThanZeroException.class, () -> greater.isGreaterThanZero(-1));
    }
}