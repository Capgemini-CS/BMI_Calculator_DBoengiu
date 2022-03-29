package com.capgemini.IMCcalculator.controllers;

import com.capgemini.IMCcalculator.entities.BMIDto;
import com.capgemini.IMCcalculator.entities.BMIEntity;
import com.capgemini.IMCcalculator.services.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
public class BMIController {

    private final BMIService bmiService;

    @Autowired
    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/BMI")
    public ResponseEntity<BMIDto> getBMI(@RequestParam @Pattern(
                                                                regexp = "^[1-9]",
                                                                message = "Height should be greater than zero")
                                         String height,

                                         @RequestParam @Pattern(
                                                 regexp = "^[1-9]",
                                                 message = "Mass should be greater than zero")
                                         String mass) {
        return bmiService.calculateBMI(height, mass);
    }
}
