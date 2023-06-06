package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas{
    
    CalculatorService calculatorService;
    
    public GestorFacturas(CalculatorService calculatorService){
        System.out.println("Ejecutando constructor gestor de facturas");
        this.calculatorService = calculatorService;
    }
}
