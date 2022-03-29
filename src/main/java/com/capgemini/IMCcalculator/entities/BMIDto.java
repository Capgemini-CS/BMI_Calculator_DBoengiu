package com.capgemini.IMCcalculator.entities;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIDto {


//    @Pattern(
//            regexp = "^[1-9]",
//            message = "You should have entered numbers")
//    @DecimalMin(value = "0",
//            message = "Height should be greater than zero")
    private int height;


//    @Pattern(
//            regexp = "^[1-9]",
//            message = "You should have entered numbers")
//    @DecimalMin(value = "0",
//            message = "Mass should be greater than zero")
    private int mass;
    private String message;

    public BMIDto(int height, int mass) {
        this.height = height;
        this.mass = mass;
    }
}
