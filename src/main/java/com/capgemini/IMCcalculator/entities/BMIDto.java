package com.capgemini.IMCcalculator.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIDto {


    private int height;
    private int mass;
    private String message;

    public BMIDto(int height, int mass) {
        this.height = height;
        this.mass = mass;
    }
}
