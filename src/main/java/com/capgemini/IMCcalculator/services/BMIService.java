package com.capgemini.IMCcalculator.services;

import com.capgemini.IMCcalculator.calculators.BMICalculatorImplementation;
import com.capgemini.IMCcalculator.converters.StringToNumberConverterImplementation;
import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import com.capgemini.IMCcalculator.validators.GreaterThanZeroValidationImplementation;
import com.capgemini.IMCcalculator.validators.NumberValidationImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BMIService {

    private final NumberValidationImplementation validateNumber;
    private final GreaterThanZeroValidationImplementation greaterThanZero;
    private final StringToNumberConverterImplementation numberConverter;
    private final BMICalculatorImplementation BMICalculator;

    public BMIService(NumberValidationImplementation validateNumber, GreaterThanZeroValidationImplementation greaterThanZero, StringToNumberConverterImplementation numberConverter, BMICalculatorImplementation bmiCalculator) {
        this.validateNumber = validateNumber;
        this.greaterThanZero = greaterThanZero;
        this.numberConverter = numberConverter;
        BMICalculator = bmiCalculator;
    }

    public ResponseEntity<String> calculateBMI(String heightInMeters, String massInKg) {
        try {
            validateNumber.isNotNumeric(heightInMeters);
            validateNumber.isNotNumeric(massInKg);

        } catch (NumberFormatException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        double height = numberConverter.convertToNumber(heightInMeters);
        double mass = numberConverter.convertToNumber(massInKg);

        try {
            greaterThanZero.isGreaterThanZero(height);
            greaterThanZero.isGreaterThanZero(mass);
        } catch (NumberShouldBeGreaterThanZeroException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(BMICalculator.calculateBMI(height, mass), HttpStatus.OK);

    }
}
