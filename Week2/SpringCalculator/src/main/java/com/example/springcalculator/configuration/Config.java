package com.example.springcalculator.configuration;

import com.example.springcalculator.service.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
