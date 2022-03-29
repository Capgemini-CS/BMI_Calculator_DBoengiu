package com.capgemini.IMCcalculator.services;

import com.capgemini.IMCcalculator.calculators.BMICalculatorImplementation;
import com.capgemini.IMCcalculator.entities.BMIDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BMIService {


    private final BMICalculatorImplementation BMICalculator;

    @Autowired
    public BMIService(BMICalculatorImplementation bmiCalculator) {

        BMICalculator = bmiCalculator;
    }

    public BMIDto calculateBMI(int heightInCm, int massInKg) {

        String message = BMICalculator.calculateBMI(heightInCm, massInKg);

        return new BMIDto(heightInCm, massInKg, message);

    }
}
