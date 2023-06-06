package com.example;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    public CalculatorService(){
        System.out.println("Calculator service");
    }
    public String holaMundo(){
        return "Hola Mundo";
    }
}
