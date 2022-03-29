package com.capgemini.IMCcalculator.validators;

import org.springframework.stereotype.Component;

@Component
public class NumberValidationImplementation implements NumberValidation{
    @Override
    public boolean isNotNumeric(String stringToNumber) {
        try {
            Double.parseDouble(stringToNumber);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }
}
