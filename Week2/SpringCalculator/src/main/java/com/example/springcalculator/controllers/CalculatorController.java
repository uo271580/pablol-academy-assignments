package com.example.springcalculator.controllers;

import com.example.springcalculator.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final Calculator calculator;
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    public CalculatorController(Calculator calculator) {
        logger.info("Creating CalculatorController");
        this.calculator = calculator;
    }

    @GetMapping("/")
    public String index() {
        logger.info("Accessing index");
        return "Welcome to my Calculator. You can: <br>- Sum (/sum?n1=XX&n2=XX)<br>- Substract (/min?n1=XX&n2" +
                "=XX)<br>- Multiply (/mul?n1=XX&n2=XX)<br>- Divide (/div?n1=XX&n2=XX)";
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int n1, @RequestParam int n2) {
        logger.info("Accessing sum with " + n1 + " and " + n2);
        return n1 + " plus " + n2 + " is " + calculator.add(n1, n2);
    }

    @GetMapping("/min")
    public String subtract(@RequestParam int n1, @RequestParam int n2) {
        logger.info("Accessing min with " + n1 + " and " + n2);
        return n1 + " minus " + n2 + " is " + calculator.minus(n1, n2);
    }

    @GetMapping("/mul")
    public String multiply(@RequestParam int n1, @RequestParam int n2) {
        logger.info("Accessing mul with " + n1 + " and " + n2);
        return n1 + " multiplied by " + n2 + " is " + calculator.multiply(n1, n2);
    }

    @GetMapping("/div")
    public String divide(@RequestParam int n1, @RequestParam int n2) {
        logger.info("Accessing div with " + n1 + " and " + n2);
        return n1 + " divided by " + n2 + " is " + calculator.divide(n1, n2);
    }
}
