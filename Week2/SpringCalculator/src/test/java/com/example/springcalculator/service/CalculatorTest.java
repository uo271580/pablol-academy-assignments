package com.example.springcalculator.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    public void addTest(){
        assertEquals(8, calculator.add(4, 4));
    }

    @Test
    public void minusTest(){
        assertEquals(2, calculator.minus(4, 2));
    }

    @Test
    public void multiplyTest(){
        assertEquals(10, calculator.multiply(2, 5));
    }

    @Test
    public void divideTest(){
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    public void divideByZeroTest(){
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
    }
}
