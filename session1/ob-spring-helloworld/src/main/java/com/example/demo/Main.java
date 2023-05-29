package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //iniciamos el contenedor de la aplicación (beans)
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService calculadora = (CalculatorService)context.getBean("calculatorService");
        String texto = calculadora.holaMundo();
        CalculatorService calculadora2 = (CalculatorService)context.getBean("calculatorService");
        System.out.println(texto);
    }
}
