package com.capgemini.IMCcalculator.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorImplementationTest {

    BMICalculatorImplementation calculator = new BMICalculatorImplementation();

    @Test
    void calculateBMI() {
        assertEquals("IMC = 24,69 (Greutate normala - Fara risc de boala)",
                calculator.calculateBMI(180, 80));
    }
}