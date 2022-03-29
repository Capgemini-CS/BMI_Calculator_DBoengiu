package com.capgemini.IMCcalculator.exceptions;

public class NumberShouldBeGreaterThanZeroException extends RuntimeException {
    public NumberShouldBeGreaterThanZeroException(String message) {
        super(message);
    }

    public NumberShouldBeGreaterThanZeroException() {
    }
}
