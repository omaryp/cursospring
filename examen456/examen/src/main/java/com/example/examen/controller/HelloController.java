package com.example.examen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    
    @GetMapping("/saludar")
    public String saludar(){
        return "Bienvenido a SpringBoot";
    }
}
