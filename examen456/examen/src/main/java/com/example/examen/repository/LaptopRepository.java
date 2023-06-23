package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop,Long>{
    
}
