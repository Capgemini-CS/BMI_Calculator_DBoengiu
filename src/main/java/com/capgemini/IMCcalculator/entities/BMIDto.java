package com.capgemini.IMCcalculator.entities;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIDto {

    @Min(1)
    @Max(250)
    private int height;

    @Min(value = 1, message = "Mass should be greater than zero")
    private int mass;
    private String message;

    public BMIDto(int height, int mass) {
        this.height = height;
        this.mass = mass;
    }
}
