package com.example.springcalculator.service;

import com.example.springcalculator.controllers.CalculatorController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {


    private static CalculatorController calculatorController;
    private static Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        calculator = mock(Calculator.class);
        calculatorController = new CalculatorController(calculator);
    }

    @Test
    public void givenBrowser_whenAccessMainPage_thenInfoIsShown() {
        assertThat(calculatorController.index(), containsString("Welcome to my Calculator"));
    }

    @Test
    public void givenIndex_whenSum_thenOperationIsShown() {
        given(calculator.add(anyInt(), anyInt())).willReturn(10);
        assertThat(calculatorController.sum(anyInt(), anyInt()), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenMin_thenOperationIsShown() {
        given(calculator.minus(anyInt(), anyInt())).willReturn(10);
        assertThat(calculatorController.subtract(anyInt(), anyInt()), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenMul_thenOperationIsShown() {
        given(calculator.multiply(anyInt(), anyInt())).willReturn(10);
        assertThat(calculatorController.multiply(anyInt(), anyInt()), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenDiv_thenOperationIsShown() {
        given(calculator.divide(anyInt(), anyInt())).willReturn(10);
        assertThat(calculatorController.divide(anyInt(), anyInt()), containsString("is 10"));
    }

    @Test
    public void givenIndex_whenDivByZero_thenErrorIsShown() {
        given(calculator.divide(anyInt(), eq(0))).willThrow(ArithmeticException.class);
        assertThat(calculatorController.divide(anyInt(), anyInt()), containsString("Division by zero is not allowed"));
    }
}
