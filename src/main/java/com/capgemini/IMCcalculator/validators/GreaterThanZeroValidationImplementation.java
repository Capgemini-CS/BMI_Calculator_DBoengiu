package com.capgemini.IMCcalculator.validators;

import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import org.springframework.stereotype.Component;

@Component
public class GreaterThanZeroValidationImplementation implements GreaterThanZeroValidation{
    @Override
    public void isGreaterThanZero(double number) {
        if (number <= 0) {
            throw new NumberShouldBeGreaterThanZeroException("Introduced value should be greater than zero");
        }
    }
}
