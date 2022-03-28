package com.capgemini.IMCcalculator.validators;

import org.springframework.stereotype.Component;

@Component
public class NumberValidationImplementation implements NumberValidation{
    @Override
    public void isNotNumeric(String stringToNumber) {
        try {
            Double.parseDouble(stringToNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You should have entered numbers");
        }

    }
}
