package com.example.examen.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.model.Laptop;
import com.example.examen.repository.LaptopRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);
    
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    @GetMapping
    @ApiOperation("Carga todas las laptop en stock")
    @ApiParam("Recurso sin parámetros")
    public ResponseEntity<List<Laptop>> getAll(){
        return new ResponseEntity<List<Laptop>>(laptopRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene una laptop del stock mediante un parámetro.")
    public ResponseEntity<Laptop> getLaptop(@ApiParam("Campo id de tipo Long") @PathVariable Long id){
        Laptop rpta = laptopRepository.findById(id).orElse(null);
        return new ResponseEntity<Laptop>(rpta, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation("Agrego una laptop al stock actual.")
    public ResponseEntity<Laptop> saveLaptop(@ApiParam("En el cuerpo de la petición llega un objeto del tipo Laptop.") @RequestBody Laptop laptop){
        Laptop rpta = laptopRepository.save(laptop);
        return new ResponseEntity<Laptop>(rpta, HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation("Actualiza una laptop del stock actual.")
    @ApiParam("En el cuerpo de la petición llega un objeto del tipo Laptop.")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop){
        log.info("Actualizando laptop : {}",laptop);
        if(laptop.getId().equals(null)){
            log.warn("No se puede actualizar elemento que no existe.");
            return ResponseEntity.badRequest().build();            
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Libro no existe");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Elimina una laptop del stock actual mediante un parámetro.")
    @ApiParam("Campo id de tipo Long") 
    public ResponseEntity<Laptop> deleteLaptop(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("Libro no existe");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build(); 
    }

    @DeleteMapping("")
    @ApiOperation("Elimina todo el stock de laptops, TENER CUIDADO.")
    public ResponseEntity<Laptop> deleteLaptops(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build(); 
    }

}
