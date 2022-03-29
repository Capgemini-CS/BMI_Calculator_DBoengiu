package com.capgemini.IMCcalculator.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BMIEntity {

    private int height;
    private int mass;
    private String message;

}
