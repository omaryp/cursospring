package com.example;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public void saludar(String nombre){
        System.out.println("Hola "+nombre+" bienvenido!");
    }
}
