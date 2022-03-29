package com.capgemini.IMCcalculator.controllers;

import com.capgemini.IMCcalculator.entities.BMIDto;
import com.capgemini.IMCcalculator.entities.BMIEntity;
import com.capgemini.IMCcalculator.services.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@RestController
public class BMIController {

    private final BMIService bmiService;

    @Autowired
    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/bmi")
    public ResponseEntity<BMIDto> getBMI(@RequestParam("height")
                                         @Valid
                                         @Pattern(
                                                  regexp = "^[1-9]",
                                                  message = "You should have entered numbers")
                                         @DecimalMin(value = "0.1",
                                                     message = "Height should be greater than zero")
                                         int height,

                                         @Valid
                                         @RequestParam("mass")
                                         @Pattern(
                                                 regexp = "^0*[1-9]\\d*$",
                                                 message = "You should have entered numbers")
                                         @DecimalMin(value = "0",
                                                 message = "Mass should be greater than zero")
                                         int mass) {
        return new ResponseEntity<>(bmiService.calculateBMI(height, mass), HttpStatus.OK);
    }
}
