package com.capgemini.IMCcalculator.validators;

import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import org.springframework.stereotype.Component;

@Component
public class GreaterThanZeroValidationImplementation implements GreaterThanZeroValidation{
    @Override
    public boolean isGreaterThanZero(double number) {
        if (number <= 0) {
            return false;
        }
        return true;
    }
}
