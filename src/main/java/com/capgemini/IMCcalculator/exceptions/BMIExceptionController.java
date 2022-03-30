package com.capgemini.IMCcalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BMIExceptionController {

    @ExceptionHandler(value = NumberFormatException.class)
    public ResponseEntity<Object> checkIfIsNumber(NumberFormatException exception) {
        return new ResponseEntity<>("You should have entered numbers", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NumberShouldBeGreaterThanZeroException.class)
    public ResponseEntity<Object> checkIfIsGreaterThanZero(NumberShouldBeGreaterThanZeroException exception) {
        return new ResponseEntity<>("Introduced value should be greater than zero", HttpStatus.BAD_REQUEST);
    }



}
