package com.capgemini.IMCcalculator.calculators;

import org.springframework.stereotype.Component;

@Component
public class BMICalculatorImplementation implements BMICalculator{

    @Override
    public String calculateBMI(double height, double mass) {
        double result;
        result = mass / (height * height);

        String resultFormatted = String.format("%.2f", result);

        String message;

        if (result >= 18.5 && result <= 24.9) {
            message = ("IMC = " + resultFormatted + " (Greutate normala - Fara risc de boala)");
        } else if (result >= 25 && result <= 29.9) {
            message = ("IMC = " + resultFormatted + " (Supraponderal)");
        } else if (result >= 30 && result <= 34.9) {
            message = ("IMC = " + resultFormatted + " (Obezitate Grad 1)");
        } else if (result >= 35 && result <= 39.9) {
            message = ("IMC = " + resultFormatted + " (Obezitate Grad 2)");
        } else if (result >= 40) {
            message = ("IMC = " + resultFormatted + " (Obezitate Morbida)");
        } else {
            message = ("IMC = " + resultFormatted + " (Subponderal)");
        }

        return message;
    }
}
