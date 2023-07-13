package com.example.laptop.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptop.model.Laptop;
import com.example.laptop.repository.LaptopRepository;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping
    public List<Laptop> getAll(){
        return laptopRepository.findAll();
    }

    @PostMapping
    public Laptop saveLaptop(@RequestBody Laptop laptop){
        return laptopRepository.save(laptop);
    }

}
