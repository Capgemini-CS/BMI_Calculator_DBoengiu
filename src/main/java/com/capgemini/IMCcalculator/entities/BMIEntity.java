package com.capgemini.IMCcalculator.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIEntity {

    private double height;
    private double mass;
    private String message;

}
