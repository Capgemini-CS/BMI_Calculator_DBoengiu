package com.capgemini.IMCcalculator.controllers;

import com.capgemini.IMCcalculator.entities.BMIDto;
import com.capgemini.IMCcalculator.entities.BMIEntity;
import com.capgemini.IMCcalculator.exceptions.ResponseClass;
import com.capgemini.IMCcalculator.services.BMIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.*;

@RestController
@Validated
public class BMIController {

    private final BMIService bmiService;

    @Autowired
    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @GetMapping("/bmi")
    public ResponseEntity<BMIDto> getBMI(@RequestParam("height")
                                         @Min(1)
                                         @Max(250)
                                         int height,

                                         @RequestParam("mass")
                                         @Min(1)
                                         int mass) {
        return new ResponseEntity<>(bmiService.calculateBMI(height, mass), HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ResponseClass> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(new ResponseClass(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/bmi",produces = { "application/json", "application/xml", "text/html" }, consumes = {
            "application/json",
            "application/xml",
            "text/xml"})
    public ResponseEntity<BMIDto> postBMI(@Valid @RequestBody BMIDto dto) {
        return new ResponseEntity<>(bmiService.calculateBMI(dto.getHeight(), dto.getMass()), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ResponseClass> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ResponseClass(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
