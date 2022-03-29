package com.capgemini.IMCcalculator.controllers;

import com.capgemini.IMCcalculator.converters.StringToNumberConverterImplementation;
import com.capgemini.IMCcalculator.entities.BMIDto;
import com.capgemini.IMCcalculator.exceptions.NumberShouldBeGreaterThanZeroException;
import com.capgemini.IMCcalculator.services.BMIService;
import com.capgemini.IMCcalculator.validators.GreaterThanZeroValidationImplementation;
import com.capgemini.IMCcalculator.validators.NumberValidationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {

    private final BMIService bmiService;
    private final NumberValidationImplementation validateNumber;
    private final GreaterThanZeroValidationImplementation greaterThanZero;
    private final StringToNumberConverterImplementation numberConverter;

    @Autowired
    public BMIController(BMIService bmiService, NumberValidationImplementation validateNumber, GreaterThanZeroValidationImplementation greaterThanZero, StringToNumberConverterImplementation numberConverter) {
        this.bmiService = bmiService;
        this.validateNumber = validateNumber;
        this.greaterThanZero = greaterThanZero;
        this.numberConverter = numberConverter;
    }

    @GetMapping("/bmi")
    public ResponseEntity<BMIDto> getBMI(@RequestParam String height,
                                         @RequestParam String mass) {

        if (validateNumber.isNotNumeric(height) || validateNumber.isNotNumeric(mass)) {
            throw new NumberFormatException();
        }

        if (!greaterThanZero.isGreaterThanZero(Double.parseDouble(height)) || !greaterThanZero.isGreaterThanZero(Double.parseDouble(mass))) {
            throw new NumberShouldBeGreaterThanZeroException();
        }

        return bmiService.calculateBMI(height, mass);
    }
}
