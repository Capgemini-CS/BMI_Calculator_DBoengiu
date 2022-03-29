package com.capgemini.IMCcalculator.services;

import com.capgemini.IMCcalculator.calculators.BMICalculatorImplementation;
import com.capgemini.IMCcalculator.converters.StringToNumberConverterImplementation;
import com.capgemini.IMCcalculator.entities.BMIDto;
import com.capgemini.IMCcalculator.entities.BMIEntity;
import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import com.capgemini.IMCcalculator.validators.GreaterThanZeroValidationImplementation;
import com.capgemini.IMCcalculator.validators.NumberValidationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

@Service
public class BMIService {

    private final NumberValidationImplementation validateNumber;
    private final GreaterThanZeroValidationImplementation greaterThanZero;
    private final StringToNumberConverterImplementation numberConverter;
    private final BMICalculatorImplementation BMICalculator;

    @Autowired
    public BMIService(NumberValidationImplementation validateNumber, GreaterThanZeroValidationImplementation greaterThanZero, StringToNumberConverterImplementation numberConverter, BMICalculatorImplementation bmiCalculator) {
        this.validateNumber = validateNumber;
        this.greaterThanZero = greaterThanZero;
        this.numberConverter = numberConverter;
        BMICalculator = bmiCalculator;
    }

    public ResponseEntity<BMIDto> calculateBMI(String heightInMeters, String massInKg) {
        try {
            validateNumber.isNotNumeric(heightInMeters);
            validateNumber.isNotNumeric(massInKg);

        } catch (NumberFormatException e) {
            Logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        double height = numberConverter.convertToNumber(heightInMeters);
        double mass = numberConverter.convertToNumber(massInKg);

        try {
            greaterThanZero.isGreaterThanZero(height);
            greaterThanZero.isGreaterThanZero(mass);
        } catch (NumberShouldBeGreaterThanZeroException e) {
            Logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String message = BMICalculator.calculateBMI(height, mass);

        return new ResponseEntity<>(new BMIDto(height, mass, message), HttpStatus.OK);

    }
}
