package com.capgemini.IMCcalculator.controllers;

import com.capgemini.IMCcalculator.services.BMIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BMIController {

    private final BMIService bmiService;

    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/BMI")
    public ResponseEntity<String> getBMI(@RequestParam String height,
                                         @RequestParam String mass) {
        return bmiService.calculateBMI(height, mass);
    }
}
