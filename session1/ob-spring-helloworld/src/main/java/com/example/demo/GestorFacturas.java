package com.example.demo;

public class GestorFacturas {
    
    CalculatorService calculatorService;
    String nombre;
    public GestorFacturas(CalculatorService calculatorService,String nombre){
        System.out.println("Ejecutando constructor gestor de facturas");
        this.calculatorService = calculatorService;
        this.nombre = nombre;
    }
}
