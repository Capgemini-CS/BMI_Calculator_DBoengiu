package com.capgemini.IMCcalculator.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIDto {

    private double height;
    private double mass;
    private String message;
}
