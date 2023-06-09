package com.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private NotificationService notService;
    
    public UserService(NotificationService notService){
        this.notService = notService;
    }

    public void lanzarSaludo(String nombre){
        notService.saludar(nombre);
    }
}
