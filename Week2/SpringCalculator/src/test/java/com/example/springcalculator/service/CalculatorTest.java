package com.example.springcalculator.service;

import com.example.springcalculator.controllers.CalculatorController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {


    private static CalculatorController calculatorController;

    @BeforeAll
    public static void beforeAll() {
        calculatorController = new CalculatorController(new Calculator());
    }


    @Test
    public void givenBrowser_whenAccessMainPage_thenInfoIsShown() {
        assertThat(calculatorController.index(), containsString("Welcome to my Calculator"));
    }

    @Test
    public void givenIndex_whenSum_thenOperationIsShown() {
        assertThat(calculatorController.sum(4, 6), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenMin_thenOperationIsShown() {
        assertThat(calculatorController.substract(16, 6), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenMul_thenOperationIsShown() {
        assertThat(calculatorController.multiply(5, 2), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenDiv_thenOperationIsShown() {
        assertThat(calculatorController.divide(40, 4), containsString("is 10"));
    }
}
